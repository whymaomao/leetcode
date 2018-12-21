package com.company;

import java.util.ArrayList;
import java.util.List;

public class No119_PascalTriageII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tempRow = new ArrayList<Integer>();
        if(rowIndex == 0)
        {
            tempRow.add(1);
            return tempRow;
        }
        for(int i = 0; i < rowIndex; i ++)
        {
            List<Integer> retRow = new ArrayList<Integer>();
            retRow.add(1);
            for(int j = 1; j < tempRow.size(); j ++)
            {
                retRow.add(tempRow.get(j-1) + tempRow.get(j));
            }
            retRow.add(1);
            tempRow.clear();
            tempRow = retRow;
        }
        return tempRow;
    }
}
