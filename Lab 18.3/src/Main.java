import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /* Lab 18.3 */
        Supplier<String> iLoveJava = () -> { return "I Love Java!"; };
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println();

        /* Lab 18.5 */
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        List<String> firstUppercaseList = new ArrayList<>();

        topNames2015.forEach(name -> firstUppercaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUppercaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUppercaseList.forEach(s -> System.out.println(s));

        firstUppercaseList.sort(String::compareTo);
        firstUppercaseList.forEach(System.out::println);

        System.out.println();

        /* Lab 18.6 */
        topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        System.out.println();

        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Names beginning with 'A' is: " + namesBeginningWithA);

//        topNames2015
//                .stream()
//                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
//                .peek(System.out::println)
//                .sorted(String::compareTo);

        System.out.println();

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

    }
}