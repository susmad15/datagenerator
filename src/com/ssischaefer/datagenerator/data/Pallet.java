package com.ssischaefer.datagenerator.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pallet {
	
	private static int number;

	private static List<Integer> numbers;
	private static List<String> strings;
	private static List<String> palletIDs;

	private static Random random = new Random();

	/* 
	 * Method that creates the pallet IDs
	 * The pallets have IDs going from 10.000.000 to 19.999.999
	 */
	private static void generatePalletIDs() {
		numbers = new ArrayList<Integer>();
		strings = new ArrayList<String>();
		palletIDs = new ArrayList<String>();
		
		//100 random pallet IDs between 10000000 and 19999999 are created
		for (int i = 0; i < 100; i++) {
			number = random.nextInt(19999999 - 10000000 + 1) + 10000000;

			if (!numbers.contains(number)) {
				numbers.add(number);
			} else {
				i--;
			}
		}

		Collections.sort(numbers);

		//The list of IDs is converted to Strings and added to another list
		for (int number : numbers) {
			strings.add(String.valueOf(number));
		}

		//The dots are put into the number to create the final ID
		for (String string : strings) {
			StringBuilder builder = new StringBuilder(string);

			builder.insert(2, '.');
			builder.insert(6, '.');

			palletIDs.add(builder.toString());
		}
	}

	//Returns the List of pallet IDs
	public static List<String> getPalletIDs() {
		generatePalletIDs();
		
		return palletIDs;
	}

}
