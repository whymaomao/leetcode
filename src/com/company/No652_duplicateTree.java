package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class No652_duplicateTree {
    public static void main(String[] args) {
        System.out.println(epochToDateString(1690804799L));
    }

    public static String epochToDateString(Long epochTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdf.format(new Date(epochTime*1000L));
    }
}
