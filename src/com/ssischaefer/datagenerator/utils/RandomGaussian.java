package com.ssischaefer.datagenerator.utils;

import java.util.Random;

// Class that can be used to apply the effect of the Gaussian/normal distribution to random numbers
public class RandomGaussian {
	
	private static Random random = new Random();
	
	/*
	 * The variable mean is the mean value, where the Gaussian distribution has the highest value, f.e. if you have a range between 0 and 50, the mean value is 25.
	 * The variable variance is the range in which the mean value goes higher and lower, f.e. if you have the mean value 25 and the variance 25, a random number between 0 and 50 will be generated.
	 * Numbers that are near the values 0 and 50 have a lower chance of being chosen, whereas the chance is greater, the more the number approaches 25, the mean value.
	 */
	public static int getRandomGaussian(int mean, double variance) {
		variance /= 4;
		
		return (int) (mean + random.nextGaussian() * variance);
	}

}
