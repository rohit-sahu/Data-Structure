package io.logical;

import java.util.HashMap;
import java.util.Stack;

public class Avataar {

    public static int isCorrect0peningAndClosing(String code) {
        Stack stack = new Stack();
        HashMap<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");
        for(int i = 0; i < code.length(); i++) {
            String data = code.charAt(i) + "";
            if(stack.empty() || ("{ ( [".contains(data) && !stack.peek().equals(map.get(data)))) {
                stack.push(data);
            } else if(stack.peek().equals(map.get(data))) {
                stack.pop();
            }
        }
        if (stack.empty()){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // write the solution here..
        System.out.println(isCorrect0peningAndClosing("[{([])}]"));
    }
}
