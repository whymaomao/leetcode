package com.yue;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class week_huawei {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1000];
        for(int i = 0; i < nums.length; i ++) {
            for(int j = 0; j < nums[i].length; j ++) {
                count[nums[i][j]] ++;
            }
        }


        int targetNum = nums.length;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < 1001; i ++) {
            if(count[i] == targetNum) {
                result.add(count[i]);
            }
        }
        return result;
    }

    private static boolean isInCircle(int x, int y, int circle_x, int circle_y, double r) {
        double xx = Math.pow(circle_x -x , 2);
        double yy = Math.pow(circle_y - y, 2);
        return (xx+yy) <= r;
    }

    public static int countLatticePoints(int[][] circles) {
        int x_min = Integer.MAX_VALUE;
        int y_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_max = Integer.MIN_VALUE;
        for (int[] circle : circles) {
            x_min = Math.min(x_min, circle[0] - circle[2]);
            x_max = Math.max(x_max, circle[0] + circle[2]);
            y_min = Math.min(y_min, circle[1] - circle[2]);
            y_max = Math.max(y_max, circle[1] + circle[2]);
        }
        Set<String> pointSet = new HashSet<>();
        int count = 0;
        for(int x = x_min; x <= x_max; x ++) {
            for(int y = y_min; y <= y_max; y++) {
                for (int[] circle : circles) {
                    double r = Math.pow(circle[2], 2);
                    if (isInCircle(x, y, circle[0], circle[1], r)) {
                        String point = x + "," + y;
                        if(!pointSet.contains(point)) {
                            count++;
                            pointSet.add(point);
                        }

                    }
                }
            }
        }
        return count;
    }

    public int percentageLetter(String s, char letter) {
        int len = s.length();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == letter) {
                count ++;
            }
        }
        return count *100 / len ;
    }

    public boolean digitCount(String num) {
        Map<Integer, Integer> digitMap = new HashMap<>();
        for(int i = 0; i < num.length(); i ++) {
            int digit = num.charAt(i) - '0';
            digitMap.put(digit, digitMap.getOrDefault(digit, 0) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < num.length(); i ++) {
            stringBuilder.append(digitMap.getOrDefault(i, 0));
        }
        return num.equals(stringBuilder.toString());
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> senderNum = new HashMap<>();
        for(int i = 0; i < messages.length; i ++) {
            int num = messages[i].split(" ").length;
            senderNum.put(senders[i], senderNum.getOrDefault(senders[i], 0) + num);
        }

        int maxNum = Integer.MIN_VALUE;
        String largestWord = new String() ;
        for(Map.Entry<String, Integer> entry : senderNum.entrySet()) {
            if(entry.getValue() > maxNum) {
                largestWord = entry.getKey();
                maxNum = entry.getValue();
            } else if(entry.getValue() == maxNum) {
                if( entry.getKey().compareTo(largestWord) > 0) {
                    largestWord = entry.getKey();
                }
            }
        }
        return largestWord;
    }

    public List<Integer> minMaxGate(List<Integer> inputArray) {
        boolean MIN_FLAG = true;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < inputArray.size(); i += 2) {
            int num1 = inputArray.get(i);
            int num2 = inputArray.get(i + 1);
            if(MIN_FLAG) {
                result.add(Math.min(num1, num2));
                MIN_FLAG = false;
            } else {
                result.add(Math.max(num1, num2));
                MIN_FLAG = true;
            }
        }
        return result;
    }

    public int minMaxGame(int[] nums) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for(int num : nums) {
            arrayList.add(num);
        }
        while(arrayList.size() > 1) {
            arrayList = minMaxGate(arrayList);
        }
        return arrayList.get(0);
    }

}
