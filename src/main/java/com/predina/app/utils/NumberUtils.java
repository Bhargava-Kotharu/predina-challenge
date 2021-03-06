package com.predina.app.utils;

/**
 * 
 * Created By @author Bhargava Kotharu on 04 August, 2018
 *
 */
public class NumberUtils {

    /**
     * This method generates random number between given minimum and maximum
     * 
     * @param maximum
     * @param minimum
     * @return
     */
    public static int getRandomInteger(int maximum, int minimum) {
	return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }
}
