package io.logical;

/**
 * int[] a = [1, -1, 2, 6, 0, 0, 0, 0 , 6, -1, -9]
 * Pivot point:
 * Sum {LHS} = SUM {RHS}
 * 8+6-1-9 = 14-1-9 = 4/2 = 2
 *
 * Return: index?
 * Or else : -1
 *
 *
 * int[] a = [1, -1, 2, 6, 0, 0, 0, 0 8]
 *
 * index = 4
 *
 * int[] a = [-1, 1, 1, -1, 2, 6, 0, 0, 0, 0 , 6, -1, -9, -3]
 * 2+6+6-1-9-3 = 14-1-9-3=1
 * prefix sum = -1, 0, 1, 0, 2, 8, 8, 8, 8, 8, 14, 13, 4, 1
 * suffix sum = 1, 2, 1, 0, 1, -1, -7, -7, -7, -7, -7, -13, -12, -3
 */
public class Rakuten {

    public static int pivotPoint(int[] arr) {
        int output = -1;
        int start = 0;
        int end = arr.length - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (start < end) {
            leftSum = leftSum + arr[start++];
            rightSum = rightSum + arr[end--];
        }
        if (leftSum == rightSum) {
            output = leftSum;
        }
        return output;
    }

    /**
     * int[] a = [1, 1, 1, 8, 8, 8, 9, 9, 9, 9, 9]
     * target = 8
     * o/p = {3, 5}
     *
     * int[] a = [1, 1, 1, 8, 8, 8, 9, 9, 9, 9, 9]
     * target = 11
     * o/p = null
     */
    public static void findElement(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int leftStart = -1;
        int leftEnd = -1;
        int rightStart = -1;
        int rightEnd = -1;
        while (start < end) {
            if (target == arr[start] && (leftStart == -1 || leftEnd == -1)) {
                if (leftStart == -1) {
                    leftStart = start++;
                } else {
                    leftEnd = ++start;
                }
            } else if (leftStart != -1 && leftEnd != -1 && target != arr[start]) {
                break;
            } else {
                start++;
            }
        }
        System.out.println(leftStart + ", "+ leftEnd);
    }

    public static void main(String[] args) {
        //System.out.println(pivotPoint(new int[]{1, -1, 2, 6, 0, 0, 0, 0, 8}));
        //findElement(new int[]{1, 1, 1, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9}, 8);
        findElement(new int[]{8}, 8);
    }
}