import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> collect = stream
                .sorted(order)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(collect.get(0), collect.get(collect.size() - 1));
        }
    }

    public static void defineAnEvenNumber(List<Integer> list) {
        List<Integer> sortedList = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Четные числа в списке: " + sortedList);
        System.out.println("Всего чисел: " + sortedList.size());
    }

    public static void printLine() {
        System.out.println("============================");
    }

    public static void main(String[] args) {
        task1();
        printLine();
        task2();
    }

    public static void task1() {
        System.out.println("Task 1");
        Stream<Integer> integerStream = Stream.of(12, 25, 21, -2, 33, 46, 1, 8, 88, 14, 15, 22);

        BiConsumer<Integer, Integer> biConsumer = (min, max) -> {
            System.out.println("Минимальное значение: " + min);
            System.out.println("Максимальное значение: " + max);
        };

        Comparator<Integer> comparator = Integer::compareTo;

        findMinMax(integerStream, comparator, biConsumer);
    }

    public static void task2() {
        System.out.println("Task 2");
        List<Integer> list = Arrays.asList(2, 1, 124, 23, 453, 564, 54, 34, 765, 45, 74, 876, 34, 65, 43, 37, 25, 457, 34, 8, 6);

        defineAnEvenNumber(list);
    }
}