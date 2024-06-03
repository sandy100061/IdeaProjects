
package org.example;

import java.lang.Math;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Math2 {
public double sqrt(double a) {
        if (a < 0) {
            return Double.NaN;
        }
        double epsilon = 1e-10;
        double guess = a;
        while (Math.abs(guess * guess - a) > epsilon) {
            guess = (guess + a / guess) / 2;
        }
        return guess;
    }

    public int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return -a;
        }
    }

    public boolean isPrime(int n){
        boolean isPrime = true;
        for(int i = 2 ; 2*i < n ; i++){
            if(n%i == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }

    public boolean isPerfect(int x) {
        int sum = 0;
        for(int i = 1; i<=(x/2); i ++) {
            if(x%i == 0) {
                sum = sum + i;
            }
        }
        if(sum == x) {
            return true;
        }else {
            return false;
        }
    }

    public int[] bubbleSort(int[] num) {
        int j;
        boolean flag = true;   // set flag to true to begin first pass
        int temp;   //holding variable
        System.out.println("bubbleSort");
        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (j = 0; j < num.length - 1; j++) {
                if (num[j] < num[j + 1])   // change to > for ascending sort
                {
                    temp = num[j];                //swap elements
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true;              //shows a swap occurred
                }
            }
        }
        return num;
    }

    public int[] selectionSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < num.length; j++)
                if (num[j] < num[index])
                    index = j;
            int smallerNumber = num[index];
            num[index] = num[i];
            num[i] = smallerNumber;
        }
        return num;
    }

    public static int lastZero(int[] x) {
        // Effects: if x == null throw NullPointerException
        // else return the index of the Last 0 in x
        // return -1 if 0 does not occur in x
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int countPositive(int[] x) {
        //Effects : if x = null throw nullPointerException
        //else return the number of positive elements in x

        int count = 0;
        for(int i=0; i < x.length ; i++) {
            if(x[i] >= 0) {
                count++;
            }
        }
        return count;
    }

}