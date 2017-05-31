package ru.sbt.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static ru.sbt.stream.Streams.of;

public class App {
    public static void main(String[] args) {
        List<Integer> listik = new ArrayList<>();
        listik.add(1);
        listik.add(2);
        listik.add(3);
        listik.add(3);
        Map<Integer, Integer> map =  Streams.of(listik)
                .filter(elem -> elem == 3)
                .transform(elem -> elem*3)
                .toMap(elem -> elem/3, elem -> elem - 3);
        System.out.println(map);
    }
}
