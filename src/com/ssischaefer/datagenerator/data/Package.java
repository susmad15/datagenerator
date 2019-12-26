package com.ssischaefer.datagenerator.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Data class for the table packages
public class Package {

	private String package_id;
	private String pallet_id;
	private int product_id;
	private int amount;
	private String container_id;

	private static List<Integer> packageAmounts;

	private static int number;

	private static List<Integer> numbers;
	private static List<String> strings;
	private static List<String> packageIDs;

	private static Random random = new Random();
	
	//The table packages consists of the package ID, the pallet ID, the product ID, the amount and the container ID
	public Package(String package_id, String pallet_id, int product_id, int amount, String container_id) {
		this.package_id = package_id;
		this.pallet_id = pallet_id;
		this.product_id = product_id;
		this.amount = amount;
		this.container_id = container_id;
	}

	//Getter and Setter
	public String getPackage_id() {
		return package_id;
	}

	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}

	public String getPallet_id() {
		return pallet_id;
	}

	public void setPallet_id(String pallet_id) {
		this.pallet_id = pallet_id;
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

	public String getContainer_id() {
		return container_id;
	}

	public void setContainer_id(String container_id) {
		this.container_id = container_id;
	}

	@Override
	public String toString() {
		return "Package [package_id=" + package_id + ", pallet_id=" + pallet_id + ", product_id=" + product_id
				+ ", amount=" + amount + ", container_id=" + container_id + "]";
	}

	/*
	 * Method that creates a list of possible amounts
	 * The possible amounts in the list are 10, 20, 30, 40, 50, 60, 70, 80 and 90
	 */
	private static void generatePackageAmounts() {
		packageAmounts = new ArrayList<Integer>();

		//Creates the list of amounts
		for (int i = 1; i < 100; i++) {
			packageAmounts.add(i);
		}
	}
	
	public static List<Integer> getPackageAmounts() {
		generatePackageAmounts();

		return packageAmounts;
	}

	/* 
	 * Method that creates the package IDs
	 * The packages have IDs going from 10.000.000 to 19.999.999
	 */
	private static void generatePackageIDs() {
		numbers = new ArrayList<Integer>();
		strings = new ArrayList<String>();
		packageIDs = new ArrayList<String>();

		//100 random unique Package IDs between 10000000 and 19999999 are created
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

			packageIDs.add(builder.toString());
		}
	}

	//Returns the List of Package IDs
	public static List<String> getPackageIDs() {
		generatePackageIDs();

		return packageIDs;
	}

}
