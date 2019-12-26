package com.ssischaefer.datagenerator.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Data Class for the table Container
public class Container {

	private String container_id;
	private int product_id;
	private int amount;
	
	private static int number;

	private static List<Integer> numbers;
	private static List<String> strings;
	private static List<String> containerIDs;

	private static Random random = new Random();

	//The table Container consists of a container ID, a product ID and an amount
	public Container(String container_id, int product_id, int amount) {
		this.container_id = container_id;
		this.product_id = product_id;
		this.amount = amount;
	}

	//Getter and Setter
	public String getContainer_id() {
		return container_id;
	}

	public void setContainer_id(String container_id) {
		this.container_id = container_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Container [container_id=" + container_id + ", product_id=" + product_id + ", amount=" + amount + "]";
	}
	
		
	/* 
	 * Method that creates the containers IDs for normal containers
	 * The containers have IDs going from 10.000.000 to 19.999.999
	 */
	
	private static void generateContainerIDs() {
		numbers = new ArrayList<Integer>();
		strings = new ArrayList<String>();
		containerIDs = new ArrayList<String>();
		
		//200 random unique container IDs are created between 10000000 and 19999999 and added to a list
		for (int i = 0; i < 200; i++) {
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

			containerIDs.add(builder.toString());
		}
	}
	
	//The list of IDs is returned
	public static List<String> getContainerIDs() {
		generateContainerIDs();
		
		return containerIDs;
	}

}
