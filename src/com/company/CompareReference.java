package com.company;

/**
 * @author ZhiPengZhang
 * @date 2022/11/7 12:22
 * @description
 **/
public class CompareReference{
    public static void main(String [] args){
        float f=42.0f;
        float f1[]=new float[2];
        float f2[]=new float[2];
        float[] f3=f1;
        long x=42;
        f1[0]=42.0f;
    }
}
