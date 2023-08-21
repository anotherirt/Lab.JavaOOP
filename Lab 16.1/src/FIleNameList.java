import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FIleNameList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();

        List<String> fileNames = getFilenamesFromDirectory(path);

        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }
    //
    private static List<String> getFilenamesFromDirectory(String path) {
        List<String> fileNames = new ArrayList<>();
        File directory = new File(path);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
    }

}
