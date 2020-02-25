package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]

 */


public class No609_findDuplicate {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> filenameMap = new HashMap<>();
        for(int i = 0; i < paths.length; i ++){
            String[] fileNameArray = paths[i].split(" ");
            String rootPaht = fileNameArray[0];
            for(int j = 1; j < fileNameArray.length; j ++){
                String fileContent = fileNameArray[j].substring(fileNameArray[j].indexOf("(") + 1,fileNameArray[j].length() - 1);
                String filePathTemp = rootPaht + "/" + fileNameArray[j].substring(0,fileNameArray[j].indexOf("("));
                List<String>filePathList;
                if(filenameMap.containsKey(fileContent)){
                    filePathList= filenameMap.get(fileContent);
                    filePathList.add(filePathTemp);
                }else {
                    filePathList = new ArrayList<>();
                    filePathList.add(filePathTemp);
                    filenameMap.put(fileContent, filePathList);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: filenameMap.entrySet()){
            if(entry.getValue().size() > 1)
                result.add(entry.getValue());
        }

        return result;
    }


    public static void main(String[] args){
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> result = No609_findDuplicate.findDuplicate(paths);
        System.out.println("test done");

    }
}
