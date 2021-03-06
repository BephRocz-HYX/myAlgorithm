package com.分类题型.数组;

import java.util.Arrays;

/**
 * 给定一个矩阵，按照转圈的方式打印矩阵
 * 思路：外圈打印
 */

public class 转圈打印矩阵 {
    public static void main(String[] args){
        int[][] mat = createMat(4,3);
        int col1 = 0;
        int row1 = 0;
        int col2 = mat.length - 1;
        int row2 = mat[0].length - 1;
        while(col1 <= col2 && row1 <= row2){
            printEdge(mat,col1++,row1++,col2--,row2--);
        }
    }
    public static int[][] createMat(int m,int n){
        int[][] mat = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                mat[i][j] = (int)(Math.random() * 10);
            }
        }
        for(int i = 0;i < m;i++){
            System.out.print(Arrays.toString(mat[i]));
            System.out.println();
        }
        return mat;
    }
    public static void printEdge(int[][] m,int row1,int col1,int row2,int col2){
        if(row1 == row2){
            for(int i = col1; i <= col2;i++){
                System.out.print(m[row1][i] + " ");
            }
        }else if(col1 == col2){
            for(int i = row1;i <= row2;i++){
                System.out.print(m[i][col1] + " ");
            }
        }else{
            int curR = row1;
            int curC = col1;
            while(curC != col2){
                System.out.print(m[row1][curC++] + " ");
            }
            while(curR != row2){
                System.out.print(m[curR++][col2] + " ");
            }
            while(curC != col1){
                System.out.print(m[row2][curC--] + " ");
            }
            while(curR != row1){
                System.out.print(m[curR--][col1] + " ");
            }
        }
    }

}
