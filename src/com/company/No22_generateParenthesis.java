package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No22_generateParenthesis {
    private void generate(String item,int left,int right,List res) {
        //左括号和右括号满足上述条件的前提下都为n个，添加这个答案
        if(left == 0 && right == 0) {
            res.add(item);
            return;
        }
        //左括号的个数小于n 才能继续放左括号
        if(left > 0) {
            generate(item+"(",left-1,right,res);
        }
        //左括号个数必须大于右括号的放置个数 才能继续放右括号
        if(left < right) {
            generate(item+")",left,right-1,res);
        }
    }
    public List<String> generateParenthesis(int n) {
        /**
         *左括号个数必须大于右括号的放置个数 才能继续放右括号
         *左括号的个数小于n 才能继续放左括号
         *左括号和右括号满足上述条件的前提下都为n个，添加这个答案
         */
        List<String> res = new ArrayList<>();
        generate("",n,n,res);
        return res;
    }




}
