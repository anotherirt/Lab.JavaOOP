import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        /* Lab 18.1 */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };
//        new Thread(runnable).start();

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };
        new Thread(runnable1).start();


        /* Lab 18.2 */
        Function<String,String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("1234567890"));

        String r = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(r);
    }

    public static String everySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }
}