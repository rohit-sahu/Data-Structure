package io.logical;

public class DictionaryProblem {

    public static boolean isStringSegmented(String str, String[] worDict) {
        boolean res = Boolean.FALSE;
        String s = str;
        for (int i = 0; i < worDict.length; i++) {
            if (s.contains(worDict[i])) {
                s = s.replace(worDict[i], "");
            }
        }
        System.out.println(s);
        if (s != null && s.equals("")) {
            res = Boolean.TRUE;
        } else {

        }
        return res;
    }

    public static void main(String[] args) {
        String[] wordDict1 = {"cat", "dog", "sand", "and", "cats"};
        String[] wordDict2 = {"apple", "pen"};
        String[] wordDict3 = {"money", "view"};
        String[] wordDict4 = {"cat", "dog", "sand", "an", "cats"};
        System.out.println(isStringSegmented("catsandog", wordDict1));
        System.out.println(isStringSegmented("applepenapple", wordDict2));
        System.out.println(isStringSegmented("moneyview", wordDict3));
        System.out.println(isStringSegmented("catsandog", wordDict4));
        System.out.println("Core Size is - " + Runtime.getRuntime().availableProcessors());
    }
}
