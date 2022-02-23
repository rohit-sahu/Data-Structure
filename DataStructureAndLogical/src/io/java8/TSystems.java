package io.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TSystems {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("32", "45", "100", "200");
        AtomicInteger integer = new AtomicInteger(0);
        stringList.forEach(s -> {
            if (s.contains("2") || s.contains("1")) {
                integer.getAndAdd(Integer.parseInt(s));
            }
        });
        System.out.println(integer.get());


    }

    //1,2,3,4,5
    public static Node reverseList(Node head) {
        Node nextNode = null;
        Node previousNode = null;
        Node currentNode = head;//1,2,3,4,5
        while (currentNode != null) {
            nextNode = currentNode.next;//2,3,4,5
            currentNode.next = previousNode;//1, null
            previousNode = currentNode;//1, null
            currentNode = nextNode;//2,3,4,5
        }
        return previousNode;
    }

    static class Node {
        int data;
        Node next;
    }
}
