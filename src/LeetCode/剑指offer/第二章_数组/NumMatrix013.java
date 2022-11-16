package LeetCode.剑指offer.第二章_数组;

import java.util.Arrays;

/**
 * @author ZhiPengZhang
 * @date 2022/11/14 20:04
 * @description 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
 **/
public class NumMatrix013 {
    int[][] sums;

    public NumMatrix013(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                rowSum += sums[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][row2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
    }
}
