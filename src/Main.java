import org.w3c.dom.ls.LSException;

import java.util.*;

import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>(List.of(20, 40, 60, 71, 2, 8, 6, 30, 55, 47));
        findMinMax(list.stream(), Integer::compareTo, (integer, integer2) -> {
            System.out.println("Min: " + integer);
            System.out.println("Max: " + integer2);
        });



    //вывод четных чисел из листа
        System.out.println(list.stream().filter(num -> num %2 == 0).collect(Collectors.toList()));

    }

    //минимальные и максимальные элементы в стриме
    public static void findMinMax(Stream<? extends Integer> stream,
                                  Comparator<? super Integer> comparator,
                                  BiConsumer<? super Integer, ? super Integer> minMaxConsumer) {
        List<Integer> list = stream.map(Integer::valueOf).toList();
        Integer min = list.stream().min(comparator).orElse(null);
        Integer max = list.stream().max(comparator).orElse(null);
        if (min == null) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(min, max);
        }
    }

}
