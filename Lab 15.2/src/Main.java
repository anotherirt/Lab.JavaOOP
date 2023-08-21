import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int bobDice;
        int aclideDice;
        int[] dices = new int[10];
        Random random = new Random();

        System.out.println("Bob tung xuc xac:");
        bobDice = s.nextInt();
        FileWriter diceFile = null;

        try {
            diceFile = new FileWriter("bob.txt");
            List<String> dicesOfBob = new ArrayList<String>();
            for (int i = 0; i < bobDice; i++) {
                dices[i] = random.nextInt(6) + 1;
                dicesOfBob.add(String.valueOf(dices[i]));
            }
            diceFile.write(String.join(" ", dicesOfBob));
            System.out.println("Diem xuc xac cua Bob: " + dicesOfBob);
            diceFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Alice tung xuc xac:");
        aclideDice = s.nextInt();

        try {
            diceFile = new FileWriter("alice.txt");
            List<String> dicesOfAlice = new ArrayList<String>();
            for (int i = 0; i < aclideDice; i++) {
                dices[i] = random.nextInt(6) + 1;
                dicesOfAlice.add(String.valueOf(dices[i]));
            }
            diceFile.write(String.join(" ", dicesOfAlice));
            System.out.println("Diem xuc xac cua Alice: " + dicesOfAlice);
            diceFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<Integer> bobDices = readDices("bob.txt");
//            System.out.println(bobDices);

            List<Integer> aliceDices = readDices("alice.txt");
//            System.out.println(aliceDices);

            String winner = getWinner(bobDices, aliceDices);
            if (winner == null) {
                System.out.println("Two people have equal points");
            } else {
                System.out.println("|||||||||||||||||||||||||");
                System.out.println("The winner is " + winner);
            }

        } catch (InvalidDiceException | NumberRollDiceNotEqualException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("The file contains non numeric data");
        }
    }

    public static List<Integer> readDices(String fileName) throws FileNotFoundException, InputMismatchException {
//        System.out.println("Read file: " + fileName);
        Scanner scanner = null;
        List<Integer> dices = new ArrayList<>();
        try {
            scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
                int dice = scanner.nextInt();
                if (dice <= 0) {
                    throw new InvalidDiceException("Dice value must greater than 0 ");
                } else if (dice > 6) {
                    throw new InvalidDiceException("Dice value must less than or equal to 6");
                } else {
                    dices.add(dice);
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return dices;
    }

    public static Integer sumOfDice(List<Integer> dices) {
        int sum = 0;
        for (int dice : dices) sum += dice;
        return sum;
    }

    public static String getWinner(List<Integer> bobDices, List<Integer> aliceDices) {
        if (bobDices.size() != aliceDices.size()) {
            throw new NumberRollDiceNotEqualException("Number of dice rolls not equal");
        }
        Integer sumBob = sumOfDice(bobDices);
        Integer sumAlice = sumOfDice(aliceDices);
        if (Objects.equals(sumBob, sumAlice)) {
            return null;
        } else if (sumBob > sumAlice) {
            return "Bob, tong diem: " + sumBob;
        } else {
            return "Alice, tong diem: " + sumAlice;
        }
    }
}