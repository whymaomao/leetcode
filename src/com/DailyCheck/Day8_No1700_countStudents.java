package com.DailyCheck;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Day8_No1700_countStudents {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        for(int student : students) {
            studentsQueue.add(student);
        }

        Queue<Integer> sandwichesQueue = new LinkedList<>();
        for(int sandwich : sandwiches) {
            sandwichesQueue.add(sandwich);
        }

        int count = 0;
        int loopCount = 0;

        while(!studentsQueue.isEmpty() && !sandwichesQueue.isEmpty()) {
            int student = studentsQueue.peek();
            int sandwitch = sandwichesQueue.peek();
            loopCount = studentsQueue.size();
            if(count == loopCount) {
                return studentsQueue.size();
            }
            if(student == sandwitch) {
                studentsQueue.poll();
                sandwichesQueue.poll();
                count = 0;
            } else {
                studentsQueue.poll();
                studentsQueue.add(student);
                count ++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwitches = {1,0,0,0,1,1};
        System.out.println(countStudents(students, sandwitches));
    }
}
