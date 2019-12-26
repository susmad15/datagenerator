package com.ssischaefer.datagenerator.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
 * Class that creates the container IDs for bad quality products
 * Other than the normal container, the bad quality containers have IDs going from 20.000.000 to 24.999.999
 */

public class BadQualityContainer {

	private static List<Integer> numbers;
	private static List<String> strings;
	private static List<String> badQualityContainerIDs;
	
	private static Random random = new Random();
	
	private static void generateBadQualityContainerIDs() {
		numbers = new ArrayList<Integer>();
		strings = new ArrayList<String>();
		badQualityContainerIDs = new ArrayList<String>();
		
		
		//50 random unique bad quality container IDs are created between 20000000 and 24999999 and added to a list
		for(int i = 0; i < 50; i++) {
			int id = random.nextInt(24999999 - 20000000 + 1) + 20000000;
			
			if(!numbers.contains(id)) {
				numbers.add(id);
			} else {
				i--;
			}
		}
		
		Collections.sort(numbers);
		
		//The list of IDs is converted to Strings and added to another list
		for(int number : numbers) {
			strings.add(String.valueOf(number));
		}
		
		//The dots are put into the number to create the final ID
		for(String string : strings) {
			StringBuilder builder = new StringBuilder(string);

			builder.insert(2, '.');
			builder.insert(6, '.');

			badQualityContainerIDs.add(builder.toString());
		}
	}
	
	//The list of IDs is returned
	public static List<String> getBadQualityContainerIDs() {
		generateBadQualityContainerIDs();
		
		return badQualityContainerIDs;
	}
	
}
