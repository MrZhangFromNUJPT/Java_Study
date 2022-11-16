package LeetCode.数组.螺旋矩阵;

/**
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
*/
public class Spiral_Matrix_II_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int loop = n / 2;
        int offset = 1;
        int startX = 0;
        int startY = 0;
        while (loop-- != 0) {
            int i = startX;
            int j = startY;
            for (; j < startY + n - offset; j++)
                matrix[i][j] = count++;
            for (; i < startX + n - offset; i++)
                matrix[i][j] = count++;
            for (; j > startY; j--)
                matrix[i][j] = count++;
            for (; i > startX; i--)
                matrix[i][j] = count++;
            startX++;
            startY++;
            offset+=2;
        }
        if(n%2==1)
            matrix[n/2][n/2] = count;
        return matrix;
    }
}
