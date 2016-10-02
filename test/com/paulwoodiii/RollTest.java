package com.paulwoodiii;

import static org.junit.Assert.assertTrue;

/**
 * Created by paul on 10/1/16.
 */
public class RollTest {

    @org.junit.Test
    public void testOneRoll() throws Exception {
        for (int i = 0; i < 10000; i++) {
            long roll = Roll.d(6);
            assertTrue(roll <= 6);
            assertTrue(roll >= 1);
        }
    }

    @org.junit.Test
    public void testTwoRoll() throws Exception {
        long total = 0;
        long i = 0;
        while (i < 10000) {
            long roll1 = Roll.d(6);
            long roll2 = Roll.d(6);
            assertTrue(roll1 <= 6);
            assertTrue(roll1 >= 1);
            total += roll1 + roll2;
            i++;
        }
        long avg = Math.round( total * 1.0f / i * 1.0f );
        assertTrue(avg == 7);
    }

    @org.junit.Test
    public void testTwoRollWithCount() throws Exception {
        long total = 0;
        long i = 0;
        while (i < 10000) {
            long roll1 = Roll.cd(2,6);
            assertTrue(roll1 <= 12);
            assertTrue(roll1 >= 2);
            total += roll1;
            i++;
        }
        long avg = Math.round( total * 1.0f / i * 1.0f );
        assertTrue(avg == 7);
    }

    @org.junit.Test
    public void testTwoRollKeepOne() throws Exception {
        long total = 0;
        long i = 0;
        while (i < 100) {
            long roll = Roll.cdk(2,6,1);
            assertTrue(roll <= 6);
            assertTrue(roll >= 1);
            i++;
        }
    }

    @org.junit.Test
    public void testTwoRollKeepTwo() throws Exception {
        long total = 0;
        long i = 0;
        while (i < 1000) {
            long roll1 = Roll.cdk(2,6,2);
            assertTrue(roll1 <= 12);
            assertTrue(roll1 >= 2);
            total += roll1;
            i++;
        }
        long avg = Math.round( total * 1.0f / i * 1.0f );
        assertTrue(avg == 7);
    }

}