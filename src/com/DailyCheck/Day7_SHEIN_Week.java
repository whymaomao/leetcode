package com.DailyCheck;

public class Day7_SHEIN_Week {
    public static int countTime(String time) {
        int count = 0;
        //last one
        char time_4th = time.charAt(4);
        char time_3rd = time.charAt(3);
        if(time_3rd == '?' || time_4th == '?') {
            if (time_3rd != '?' && (time_3rd - '0') <= 5) {
                count = 10;
            } else if (time_3rd != '?' && (time_3rd - '0') == 6) {
                count = 1;
            }
            // third one
            if (time_4th != '?' && (time_4th - '0') == 0) {
                count = 7;
            } else if (time_4th != '?' && (time_4th - '0') != 0) {
                count = 6;
            }
            if (time_3rd == '?' && time_4th == '?') {
                count = 60;
            }
        }

        int count_2 = 0;
        // second one
        char time_2nd = time.charAt(1);
        char time_1st = time.charAt(0);

        if(time_1st == '?' || time_2nd == '?') {
            if (time_1st != '?' && (time_1st - '0') <= 1) {
                count_2 = 10;
            } else if (time_1st != '?' && (time_1st - '0') == 2) {
                count_2 = 4;
            }

            // first one
            if (time_2nd != '?' && (time_2nd - '0') >= 3) {
                count_2 = 2;
            } else if (time_2nd != '?' && (time_2nd - '0') < 3) {
                count_2 = 3;
            }
            if (time_2nd == '?' && time_1st == '?') {
                count_2 = 24;
            }
        }

        if(count_2 == 0 && count == 0) {
            return 1;
        } else if(count == 0 ) {
            return count_2;
        } else if(count_2 == 0) {
            return count;
        }  else {
            return count_2 * count;
        }
    }

    public static void main(String[] args) {
        System.out.println(countTime("21:08"));
    }
}
