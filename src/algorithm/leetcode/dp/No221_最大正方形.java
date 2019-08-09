package algorithm.leetcode.dp;

import com.sun.javaws.IconUtil;

public class No221_最大正方形 {
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        //
        int [][] ret = new int[row][col];
        //在遍历中记录最大值
        int max = 0;
        //初始化第一行
        for(int i = 0;i<col;i++){
            ret[0][i]=matrix[0][i]-48;
            max = ret[0][i]>max?ret[0][i]:max;
        }
        //初始化第一列
        for(int i = 0;i<row;i++){
            ret[i][0] = matrix[i][0]-48;
            max = ret[i][0]>max?ret[i][0]:max;
        }
        // 从[1][1]开始，逐个有钱3个（上，左，左上）递推
        for(int i =1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(matrix[i][j]=='0')
                    ret[i][j]=0;
                else {
                    int left = ret[i-1][j];
                    int top = ret[i][j-1];
                    int left_top = ret[i-1][j-1];
                    if(left>0&&top>0&&left_top>0)
                        ret[i][j] = Math.min(left_top,Math.min(left,top))+1;
                    else
                        ret[i][j]=1;
                    max = ret[i][j]>max?ret[i][j]:max;
                }
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        char[][] test ={{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        maximalSquare(test);
    }
}
