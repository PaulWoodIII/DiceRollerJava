package com.paulwoodiii;

import java.util.Arrays;

/**
 * Created by paul on 10/1/16.
 */
public class Roll {
    public static int d(int sides){
        return (int) (Math.random() * sides) + 1;
    }

    public static int cd(int count, int sides){
        int c = count;
        int total = 0;
        while (c > 0){
            total += Roll.d(sides);
            c--;
        }
        return total;
    }

    public static int cdk(int count, int sides, int keep){
        int[] n = new int[keep];
        Arrays.fill(n, 0);
        while (count > 0){
            int roll = Roll.d(sides);
            boolean kept = false;
            // Fill the array first
            for (int i = 0; i < n.length; i++) {
                if(n[i] == 0){
                    n[i] = roll;
                    i = n.length;
                    kept = true;
                }
            }
            // Search for better rolls second
            if(!kept){
                for (int i = 0; i < n.length; i++) {
                    if (n[i] < roll){
                        n[i] = roll;
                        i = n.length;
                    }
                    // else don't save the roll
                }
            }
            count--;
        }
        int total = Arrays.stream(n).sum();
        return total;
    }

}
