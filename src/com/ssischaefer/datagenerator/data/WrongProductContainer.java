package com.ssischaefer.datagenerator.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 
 * Class that creates the container IDs for wrong products
 * Other than the normal container, the wrong product containers have IDs going from 25.000.000 to 29.999.999
 */
public class WrongProductContainer {

	private static List<Integer> numbers;
	private static List<String> strings;
	private static List<String> wrongProductContainerIDs;
	
	private static Random random = new Random();
	
	private static void generateWrongProductContainerIDs() {
		numbers = new ArrayList<Integer>();
		strings = new ArrayList<String>();
		wrongProductContainerIDs = new ArrayList<String>();
		
		//50 random unique wrong item container IDs are created between 25000000 and 29999999 and added to a list
		for(int i = 0; i < 50; i++) {
			int id = random.nextInt(29999999 - 25000000 + 1) + 25000000;
			
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

			wrongProductContainerIDs.add(builder.toString());
		}
	}
	
	//The list of IDs is returned
	public static List<String> getWrongProductContainerIDs() {
		generateWrongProductContainerIDs();
		
		return wrongProductContainerIDs;
	}
	
}
