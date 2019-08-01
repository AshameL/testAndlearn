package algorithm.leetcode.dp;

import java.util.LinkedList;
import java.util.List;

public class No120_三角形最短路径 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> f =triangle.get(triangle.size()-1);// 滚动数组
        List<Integer> g=new LinkedList<>();
        for(int i =n-2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                triangle.get(i).set(j,triangle.get(i).get(j)
                        +Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
