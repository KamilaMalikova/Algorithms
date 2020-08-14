package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class StairCase {
    //Time complexity: O(n)
    //Space complexity: O(n)
    public Integer[] paidStaircase(int n, int[] p){
        int[] dp = new int[n+1];
        int[] l = new int[n+1];
        dp[0] = 0;
        dp[1] = p[1];
        for (int i = 2; i <= n; i++) {
            if (dp[i-1] <= dp[i-2]){
                l[i] = i-1;
                dp[i] = dp[i-1]+p[i];
            }else {
                l[i] = i-2;
                dp[i] = dp[i-2]+p[i];
            }
            //dp[i] = this.min(dp[i-1], dp[i-2])+p[i];
        }
        LinkedList<Integer> list = new LinkedList<>();
        int i = n;
        list.add(i);
        while (i > 0){
            list.addFirst(l[i]);
            i = l[i];
        }
        Integer[] ls = new Integer[list.size()];
        ls = list.toArray(ls);
        return ls;
    }
    private int min(int a, int b){
        return (a <= b) ? a : b;
    }

    public int grid(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 & j> 0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else if (i > 0){
                    dp[i][j] = dp[i-1][j];
                }
                else if (j > 0){
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m-1][n-1];

    }

    public int uniquePathsWithObstacles(int[][] grid){
        int m= grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                else if (i > 0 & j> 0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else if (i > 0){
                    dp[i][j] = dp[i-1][j];
                }
                else if (j > 0){
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m-1][n-1];
    }

    public int maxProfit(int[][] dp){
        int m= dp.length;
        int n = dp[0].length;
        int[][][] list = new int[m][n][2];
        //dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 & j> 0){
                    if (dp[i-1][j] >= dp[i][j-1]){
                        dp[i][j] += dp[i-1][j];
                        list[i][j][0] = i-1;
                        list[i][j][1] = j;
                    }else{
                        dp[i][j] += dp[i][j-1];
                        list[i][j][0] = i;
                        list[i][j][1] = j-1;                    }
//                    dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
                }else if (i > 0){
                    dp[i][j] += dp[i-1][j];
                    list[i][j][0] = i-1;
                    list[i][j][1] = j;
                }
                else if (j > 0){
                    dp[i][j] += dp[i][j-1];
                    list[i][j][0] = i;
                    list[i][j][1] = j-1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Arrays.toString(list[i][j])+", ");
            }
            System.out.println();
        }

        LinkedList<Integer[]> ls = new LinkedList<>();
        int i = m-1;
        int j = n-1;
        Integer[] t = {i, j};
        ls.addFirst(t);
        while (i > 0 || j > 0){
            Integer[] t1 = {list[i][j][0], list[i][j][1]};
            ls.addFirst(t1);
            i = t1[0];
            j = t1[1];
        }
        for (Integer[] v: ls) {
            System.out.print(Arrays.toString(v)+", ");
        }
        return dp[m-1][n-1];
    }
}
