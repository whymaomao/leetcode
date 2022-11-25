package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class week_317 {

    // No 2455
    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int num : nums) {
            if(num % 3 == 0 && num % 2 == 0) {
                sum += num;
                count ++;
            }
        }
        if(count == 0) {
            return 0;
        } else {
            return sum / count;
        }
    }

    class CreatorViewID {
        String creator;
        String id;
        int sumViews;
        int maxView;

        CreatorViewID(String creator, String id, int sumViews, int maxView) {
            this.creator = creator;
            this.id = id;
            this.sumViews = sumViews;
            this.maxView = maxView;
        }
    }

    // No 2456
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, CreatorViewID> mapCreator = new HashMap<>();
        int maxAllView = 0;
        for(int i = 0; i < creators.length; i ++) {
            if(mapCreator.containsKey(creators[i])){
                CreatorViewID currentCreator = mapCreator.get(creators[i]);
                currentCreator.sumViews += views[i];
                if(views[i] > currentCreator.maxView) {
                    currentCreator.maxView = views[i];
                    currentCreator.id = ids[i];

                } else if((views[i] == currentCreator.maxView) && (ids[i].compareTo(currentCreator.id) < 0) ) {
                    currentCreator.id = ids[i];
                }
                maxAllView = Math.max(maxAllView, currentCreator.maxView);
                mapCreator.put(creators[i], currentCreator);
            } else{
                maxAllView = Math.max(maxAllView, views[i]);
                mapCreator.put(creators[i], new CreatorViewID(creators[i], ids[i],  views[i], views[i]));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, CreatorViewID> entry : mapCreator.entrySet()) {
            CreatorViewID creatorViewID = entry.getValue();
            if(creatorViewID.sumViews == maxAllView) {
                List<String> mostCreator = new ArrayList<>(2);
                mostCreator.add(entry.getKey());
                mostCreator.add(creatorViewID.id);
                result.add(mostCreator);
            }
        }
        return result;
    }


     int getIntegerSum(long n) {
        int sum = 0;
        long temp = n;
        while(temp != 0) {
           sum += temp % 10;
           temp = temp / 10;
        }
        return sum;
    }

     long getNextZeroNum(long n) {
        long temp = n;
        long ten = 1;
        while(temp != 0) {
            if(temp % 10 == 0) {
                temp = temp / 10;
                ten *= 10;
            } else {
                temp = temp / 10;
                ten *= 10;
                return (temp + 1) * ten;
            }
        }
        return n;
    }

    public  long makeIntegerBeautiful(long n, int target) {
        long beautiful = 0;
        long currentNum = n;
        while(getIntegerSum(currentNum) > target) {
            currentNum = getNextZeroNum(currentNum);
            beautiful = currentNum - n;
        }
        return beautiful;
    }

    public static void main(String[] args) {
     //   System.out.println(makeIntegerBeautiful(16,6));
    //    System.out.println(makeIntegerBeautiful(467, 6));
      //  System.out.println(makeIntegerBeautiful(1,1));
    }
}
