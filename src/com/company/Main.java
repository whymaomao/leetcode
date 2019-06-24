package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Main{


    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        String lastBaseline = "1561019674968";
        Long lastBaselineLong = Long.valueOf(lastBaseline);

        Long nextBaselineLong = lastBaselineLong + 1440*60000;
        System.out.println(nextBaselineLong);

        System.out.println((nextBaselineLong - System.currentTimeMillis())/60000);


    }


}
