package com.company;
import java.util.*;
import com.yue.finalUtilityTestClass;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    enum Weekday {
        Monday ("mon");

        String name;
        public String getName(){return name;}

        Weekday(String name) {
            this.name = name;
        }
    }
    final static String TEST_FILE = "/Users/yueh/XMSCodeRepo/leetcode/src/com/yue/test.file";
    private static final String USER_NAME_INVALID_CHARACTER_PATTERN = "^[^/\\\\<>]+$";

    private static final String USER_NAME_DOT_CHARACTER_PATTERN = "^[^\\.]+(\\.[^\\.]+)*$";
    public static void main(String[] args) {
        System.out.println(Weekday.Monday.getName());
//        // 1000\
//        int len = 8;
//
//        //Pattern.compile(USER_NAME_INVALID_CHARACTER_PATTERN);v
//        System.out.println("/test --> " + Pattern.matches(USER_NAME_INVALID_CHARACTER_PATTERN, "/test"));
//        System.out.println("\\test --> " + Pattern.matches(USER_NAME_INVALID_CHARACTER_PATTERN, "\\\\test"));
//        System.out.println("<test --> " + Pattern.matches(USER_NAME_INVALID_CHARACTER_PATTERN, "<test>"));
//        System.out.println("test --> " + Pattern.matches(USER_NAME_INVALID_CHARACTER_PATTERN, "test"));
//        System.out.println("t/es\\t> --> " + Pattern.matches(USER_NAME_INVALID_CHARACTER_PATTERN, "t/es\\t>"));
//
//        System.out.println("test. --> " + Pattern.matches(USER_NAME_DOT_CHARACTER_PATTERN, "test."));
//        System.out.println("test --> " + Pattern.matches(USER_NAME_DOT_CHARACTER_PATTERN, "test"));
//        System.out.println("test.test --> " + Pattern.matches(USER_NAME_DOT_CHARACTER_PATTERN, "test.test"));
//        System.out.println(".test --> " + Pattern.matches(USER_NAME_DOT_CHARACTER_PATTERN, ".test"));


//        String token = "eyJleHBEYXRlIjoiMjAyMi0wOC0wNFQxODoxNDo0MiswMDAwIiwidG9rZW4iOiJQTWI4TGhkMUlTRjJVclVNRThHRXZPTENKdDBLenZhYUZVM3FJNGhqRCtkclRySVFIdGZieGw3RkxLeEIrenpKTXBrSzREZnNOTzBqeDBtaGUrT2dxT09uM2JWdHFjNERNMWpudjR0YW9OME1JWll0TUZOYmRxQTFNZ0p6T3ZnejFVTXZrdDFHeEVHQ082MjMrb1IzeDNTem9DMkZDUlNvS2oxMUFoUkFKeENFelA2KzFmMFVTczFDWkFTK2VEcnUiLCJvcmdOYW1lIjoiQ2l0cml4IFN5c3RlbXMifQ==";
//        System.out.println(token.length());
//        System.out.println(len >> 2);
//
//        System.out.println(len - (len >> 2));
//
//        System.out.println("eyJvcmdOYW1lIjoiQ0lUUklYIFNZU1RFTVMgRlJBTkNFIiwiZXhwRGF0ZSI6IjIwMTYtMTEtMThUMDY6MDQ6MDYtMDgwMCIsInRva2VuIjoiOGwrVkJSM2VNdXIyamNKZTlrOW04Tk5VZzdnK3BNQVI3b202cGRoSGg2Z0FtQ2tzZjhEQnlhcnJLeU56Qit0UVlKbHRsTWJZQUQ0K0VzMUwrNUZTMHc9PSJ9");
//        System.out.println(hideStoken("eyJvcmdOYW1lIjoiQ0lUUklYIFNZU1RFTVMgRlJBTkNFIiwiZXhwRGF0ZSI6IjIwMTYtMTEtMThUMDY6MDQ6MDYtMDgwMCIsInRva2VuIjoiOGwrVkJSM2VNdXIyamNKZTlrOW04Tk5VZzdnK3BNQVI3b202cGRoSGg2Z0FtQ2tzZjhEQnlhcnJLeU56Qit0UVlKbHRsTWJZQUQ0K0VzMUwrNUZTMHc9PSJ9"));
////        System.out.println(minSteps("leetcode", "coats"));
////        File file = new File(TEST_FILE);
////        try {
////            if (!file.exists()) {
////                file.createNewFile();
////                System.out.println("file not exist,create it");
////            }
////            changeFTUTokenFilePermission();
////        } catch(IOException ioException) {
////
////        }
//        Hashtable<String, String> testHashTable = new Hashtable<>();
//        HashMap<String, String> testHashMap = new LinkedHashMap<>();
//        testHashTable.put("test2", "test2");
//        testHashTable.put("test3", "test3");
//        testHashTable.put("test1", "test1");
//        String test = "test1";
//
//        testHashMap.put("test2", "test2");
//        testHashMap.put("test3", "test3");
//        testHashMap.put("test1", "test1");
//
//        Enumeration enumeration = Collections.enumeration(testHashTable.keySet());
//        while (enumeration.hasMoreElements()) {
//            System.out.println("HashTable" + enumeration.nextElement());
//        }
//
//        final Enumeration<String> strEnum = Collections.enumeration(testHashMap.keySet());
//        while (strEnum.hasMoreElements()) {
//            System.out.println("HashMap" + strEnum.nextElement());
//        }
//

    }

    private static void changeFTUTokenFilePermission() throws IOException {
        Set<PosixFilePermission> filePermissions = new HashSet<>();
        filePermissions.add(PosixFilePermission.OWNER_READ);
        filePermissions.add(PosixFilePermission.OWNER_WRITE);
        filePermissions.add(PosixFilePermission.GROUP_READ);
        Path path = Paths.get(TEST_FILE);
        Files.setPosixFilePermissions(path, filePermissions);
    }

    public static int minSteps(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for(int i = 0; i < s.length(); i ++) {
            sCount[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < t.length(); i ++) {
            tCount[t.charAt(i) - 'a'] ++;
        }

        int count = 0;
        for(int i = 0; i < 26; i ++) {
            if(sCount[i] < tCount[i]) {
                count += (tCount[i] - sCount[i]);
            } else if(sCount[i] > tCount[i]) {
                count += (sCount[i] - tCount[i]);
            } else {
                continue;
            }
        }

        return count;
    }


    public static String hideStoken(String stoken) {
        int len = stoken.length();
        return stoken.substring(0, len >> 2) + "**********" + stoken.substring(len - (len >> 2));
    }

}
