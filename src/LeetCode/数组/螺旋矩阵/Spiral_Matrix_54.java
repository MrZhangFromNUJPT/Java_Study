package LeetCode.数组.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
给你一个 m 行 n 列的矩阵 matrix ，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
*/
public class Spiral_Matrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int loop = Math.min(n, m) / 2;
        int startX = 0;
        int startY = 0;
        int offset = 1;
        while (loop-- != 0) {
            int i = startX;
            int j = startY;
            for (; j < startY + m - offset; j++)
                list.add(matrix[i][j]);
            for (; i < startX + n - offset; i++)
                list.add(matrix[i][j]);
            for (; j > startY; j--)
                list.add(matrix[i][j]);
            for (; i > startX; i--)
                list.add(matrix[i][j]);
            startX++;
            startY++;
            offset += 2;
        }
        //行列相等且为奇数
        if (n == m && n % 2 == 1) {
            list.add(matrix[n / 2][n / 2]);
        }
        //针对列大于行且行是奇数的时候；
        if (m > n && n % 2 == 1)
            for (int i = startY; i <= startX + m - offset; i++)
                list.add(matrix[n / 2][i]);
        //针对行大于列且列是奇数的时候；
        if (m < n && m % 2 == 1)
            for (int i = startX; i <= startY + n - offset; i++)
                list.add(matrix[i][m / 2]);
        return list;
    }
}
