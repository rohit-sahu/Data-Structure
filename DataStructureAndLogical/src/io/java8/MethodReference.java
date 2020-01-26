package io.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
        List<String> players = Arrays.asList("Kapil", "Sachin", "Kholi", "Dhoni", "Shewag", "Dravid");
        //players.parallelStream().sorted((s, t1) -> s.compareTo(t1)).forEach(System.out::println);
        players.parallelStream().sorted(String::compareTo).forEach(System.out::println);
        System.out.println("===============================================================");
        players.stream().forEach(x -> {
            Printer printer = (s, parser) -> System.out.println(parser.parse(s));
            //printer.print(x, s -> StringParser.parse(s));//Lamda function
            printer.print(x, StringParser::parse);//Method reference
        });
    }
}

interface Parser {
    public String parse(String s);
}

class StringParser {
    public static String parse(String s) {
        if (s.length() > 3)
            return s.toUpperCase();
        else
            return s.toLowerCase();
    }
}

interface Printer {
    public void print(String s, Parser parser);
}
