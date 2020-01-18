package io.logical;

import java.util.ArrayList;

public class DistinctStringCount {

    public static void solution(int n, int q, int arr[], String zenStr) {
        // Write your solution here
        q = 0;
        ArrayList<String> al = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String s = zenStr.substring(i, j + 1);
                if (!al.contains(s)) {
                    al.add(s);
                    arr[q] = (int) s.chars().distinct().count();
                } else {
                    arr[q] = -1;
                }
                q++;
            }
        }
        for (int i = 0; i < q; i++) {
            System.out.println(arr[i]);
        }
        return;
    }

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String input = br.readLine();
        String input = "3 6";
        int n, q;
        n = Integer.parseInt(input.split(" ")[0]);
        q = Integer.parseInt(input.split(" ")[1]);
        //String zenStr = br.readLine();
        String zenStr = "aba";
        int arr[];
        arr = new int[q];
        for (int i = 0; i < q; i++) {
            //arr[i] = Integer.parseInt(br.readLine());
            arr[i] = Integer.parseInt("0");
        }
        solution(n, q, arr, zenStr);
    }
}
