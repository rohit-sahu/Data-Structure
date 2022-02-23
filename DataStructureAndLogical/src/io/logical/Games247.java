package io.logical;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Given a complete binary tree, return the value of the rightmost node of the last level.
 *
 *                      1
 *                   /    \
 *                 2      3
 *               /   \    /
 *             -2   1  -5
 */
public class Games247 {

    /*public static int rightMostNode(Node node) {
        Node left = null;
        Node right = null;
        int data = 0;
        if(node != null) {
            left = node.left;
            right = node.right;
            data = left.data;
            data = right.data;
            //rightMostNode(left);
           //rightMostNode(right);
        }
        return data;
    }*/

    /*static class Node {
        int data;
        Node left;
        Node right;
    }*/

    public static void main(String[] args) {
        String str = "abcdefghiabc";
        //int counter = (int) Arrays.stream(str.split("abc")).filter(s -> s.equals("abc")).count();
        //Collections.singletonList(str.toCharArray());
    }
}
