package com.yue;

public class binarySearchPractice {

    public static int myWrongSqrt(int x) {
        int start = 0;
        int end = x;
        while(start <= end) {
            int mid = start + (end - start)/2;
            long temp = (long)mid * (long)mid;
            if(temp == x) {
                return mid;
            } else if( temp > x) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static int correctSqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        if(end == 0 || target < letters[0] || target >= letters[end]) {
            return letters[0];
        }
        while(start <= end) {
            int mid = start + (end - start)/2;
            char temp = letters[mid];
            if(temp > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start];
    }



    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'g'};
        System.out.println("32101da9-d627-4a25-9a93-1bc52f411079".length());
        //System.out.println(myWrongSqrt(9));
    }
}
