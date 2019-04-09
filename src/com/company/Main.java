package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Main{



    private static void testReflect()
    {
        Main main = new Main();
        System.out.println(main.getClass().getName());
    }

    public static void main(String[] args) {
        System.out.println(TestEnumType.Friday.toString());
        System.out.println(TestEnumType.Friday.name());

        System.out.println("Friday".equals(TestEnumType.Friday.toString()));

    }


}
