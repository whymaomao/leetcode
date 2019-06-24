package com.company;

public class No999_numRookCaptures {
    private boolean stopGo(char[][]board, int row, int column,Integer count)
    {
        char role = board[row][column];
        if(role == 'p')
        {
            count ++;
            return true;
        }
        else if(role == 'B') return true;
        else return false;
    }

    public int numRookCaptures(char[][] board) {
        Integer num = 0;
        int rowIndex = 0;
        int colunmIndex = 0;
        for(int i = 0; i < 8; i ++)
        {
            for(int j = 0; j < 8; j ++)
            {
                if(board[i][j] == 'R')
                {
                    rowIndex = i; colunmIndex = j;
                }
            }
        }

        //upSearch
        for(int i = rowIndex - 1; i >= 0; i --)
        {
            if(stopGo(board,i,colunmIndex,num)) break;
        }

        //downSearch
        for(int i = rowIndex + 1; i <= 7; i ++)
        {
            if(stopGo(board,i,colunmIndex,num)) break;
        }

        //leftSearch
        for(int i = colunmIndex- 1; i >= 0; i --)
        {
            if(stopGo(board,rowIndex,i,num)) break;
        }

        //rightSearch
        for(int i = colunmIndex + 1; i <= 7; i ++)
        {
            if(stopGo(board,rowIndex,i,num)) break;
        }

        return (int)num;
    }
}
