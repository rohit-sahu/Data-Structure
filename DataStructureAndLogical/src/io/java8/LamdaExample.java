package io.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LamdaExample {

    public static void main(String[] args) {
        //Imperative Style using anonymous function
        Game football = new Game() {
            @Override
            public void play() {
                System.out.println("I am playing football");
            }
        };
        football.play();
        //Imperative Style using Implementation class
        Game tennis = new Tennis();
        tennis.play();
        //Lamda Function (removes boilerplate code)
        Game foosball = () -> System.out.println("I am playing foosball");
        foosball.play();

        Series cricket = new Series() {
            @Override
            public void play(String type) {
                System.out.println("I am playing " + type + "series of cricket");
            }
        };
        cricket.play("ODDI");

        //Series houseRidding = (type) -> System.out.println("I am playing " + type + "series of house ridding...");
        //Series houseRidding = type -> System.out.println("I am playing " + type + "series of house ridding...");
        Series houseRidding = type -> {
            System.out.println("I am playing " + type + "series of house ridding...");
        };
        houseRidding.play("One Day");

        List<String> players = Arrays.asList("Kholi", "Sachin", "Dravid", "Dhoni", "Shewag");
        //forEach Method
        players.forEach(System.out::println);
        System.out.println("=============================================================");
        for (String player: players) {
            if (player.equals("Sachin")) {
                System.out.println(player + " is in the squad....");
            }
        }
        System.out.println("=============================================================");
        players.stream().filter(player -> player.equals("Sachin")).forEach(System.out::println);
        System.out.println("=============================================================");
        Optional<String> optional = players.stream().filter(player -> player.equals("Sachin")).findFirst();
        optional.ifPresent(System.out::println);
        System.out.println("=============================================================");
        List<String> stringList = players.stream().filter(x -> x.equals("Sachin") || x.equals("Kholi")).collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }
}

interface Game {
    void play();
}

interface Series {
    void play(String type);
}

class Tennis implements Game {

    @Override
    public void play() {
        System.out.println("I am playing tennis..");
    }
}