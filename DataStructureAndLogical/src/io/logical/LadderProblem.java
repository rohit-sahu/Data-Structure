//package io.logical;
//
//import java.util.*;
//
//public class LadderProblem {
//    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int distance = 0;
//        if(!wordList.contains(endWord)) {
//            return 0;
//        }
//        for(int i = 0; i < wordList.size(); i++) {
//            if(i == 0) {
//                distance = isLadderText(beginWord, wordList.get(i)) ? 1 : 0;
//            } else {
//                distance = isLadderText(wordList.get(i - 1), wordList.get(i)) ? distance + 1 : distance;
//            }
//        }
//        return distance;
//    }
//
//    public static boolean isLadderText(String beginWord, String endWord) {
//        boolean isLadder = false;
//        if(beginWord.equals(endWord)) {
//            return isLadder;
//        }
//        HashMap map = new HashMap();
//        char begin[] = beginWord.toCharArray();
//        char end[] = endWord.toCharArray();
//        for(int i = 0; i < begin.length; i++) {
//            if(begin[i] == end[i]) {
//                map.put(i, String.valueOf(begin[i]));
//            }
//        }
//        if(map.size() == begin.length -1) {
//            isLadder = true;
//        }
//        return isLadder;
//    }
//
//    public static void main(String[] args) {
////        ArrayList list = new ArrayList();
////        list.add("hot");
////        list.add("dog");
////        System.out.println(ladderLength("hot", "dog", list));
//        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
//    }
//}
