package io.logical;

public class StringProblem {

    public static Set getUpperCaseArray(String str) {
        LinkedHashSet<String> output = new LinkedHashSet<>();
        output.add(str);
        for (int i = str.length() - 1; i >= 0; i--) {
            try {
                if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                    String temp = str.substring(0, i);
                    temp = temp + String.valueOf(str.charAt(i)).toUpperCase();
                    if (i < str.length() - 1) {
                        temp = temp + str.substring(i + 1);
                    }
                    output.add(temp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        output.add(str.toUpperCase());
        return output;
    }

    public static void main(String[] args) {
        String str = "a1b2";
        Set<String> result = getUpperCaseArray(str);
        result.forEach(System.out::println);
        str = "3z4";
        Set<String> result2 = getUpperCaseArray(str);
        result2.forEach(System.out::println);
    }
}