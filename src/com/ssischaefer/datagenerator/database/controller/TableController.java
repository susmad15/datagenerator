package com.ssischaefer.datagenerator.database.controller;

import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.ssischaefer.datagenerator.data.BadQualityContainer;
import com.ssischaefer.datagenerator.data.Container;
import com.ssischaefer.datagenerator.data.Image;
import com.ssischaefer.datagenerator.data.Package;
import com.ssischaefer.datagenerator.data.Pallet;
import com.ssischaefer.datagenerator.data.Product;
import com.ssischaefer.datagenerator.data.WrongProductContainer;
import com.ssischaefer.datagenerator.database.OracleDB;
import com.ssischaefer.datagenerator.utils.RandomGaussian;

public class TableController {

	private static List<String> imageURLs;
	private static List<Product> products;
	private static List<String> productNames;

	private static List<String> packageIDs;
	private static List<String> palletIDs;

	// The lists that are later put on the database
	private static List<String> tableBadQualityContainerIDs;
	private static List<String> tableContainerIDs;
	private static List<String> tablePalletIDs;
	private static List<Integer> tableProductAmounts;
	private static List<Integer> tableProductIDs;
	private static List<String> tableWrongProductContainerIDs;
	private static List<String> bigContainerIDList = Container.getContainerIDs();

	private static List<Container> badQualityContainers;
	private static List<Container> containers;
	private static List<Package> packages;
	private static List<Container> wrongProductContainers;

	private static Random random;

	private static Statement stmt;
	private static String query;

	/*
	 * Method that creates the data for the table product (product id, product name,
	 * product image) and fills it into a list The data from the list is then
	 * directly put onto the database
	 */
	public static void generateTableProduct() {
		imageURLs = Image.getImageURLs();
		products = new ArrayList<Product>();
		productNames = Product.getProductNames();

		try {
			OracleDB.connect();

			stmt = OracleDB.getConnection().createStatement();
			query = "";

			for (int i = 0; i < imageURLs.size(); i++) {
				Product p = new Product(i + 1, productNames.get(i), imageURLs.get(i));

				products.add(p);
			}

			for (Product p : products) {
				query = "INSERT INTO product VALUES (" + p.getId() + ", '" + p.getName() + "', '" + p.getImage() + "')";

				stmt.executeQuery(query);
			}

			OracleDB.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method that creates the data for the table container (container id, product
	 * id, amount) and fills it into a list The data from the list is then directly
	 * put onto the database
	 */
	public static void generateTableContainer() {
		containers = new ArrayList<Container>();
		// tableContainerIDs = Container.getContainerIDs();

		try {
			OracleDB.connect();

			stmt = OracleDB.getConnection().createStatement();
			query = "";

			for (String containerID : bigContainerIDList) {
				Container c = new Container(containerID, 0, 0);

				containers.add(c);
			}

			for (Container c : containers) {
				query = "INSERT INTO container VALUES ('" + c.getContainer_id() + "', " + c.getProduct_id() + ", "
						+ c.getAmount() + ")";

				stmt.executeQuery(query);
			}

			OracleDB.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method that creates the data for the table bad quality container (container
	 * id, product id, amount) and fills it into a list The data from the list is
	 * then directly put onto the database
	 */
	public static void generateTableBadQualityContainer() {
		badQualityContainers = new ArrayList<Container>();
		tableBadQualityContainerIDs = BadQualityContainer.getBadQualityContainerIDs();

		try {
			OracleDB.connect();

			stmt = OracleDB.getConnection().createStatement();
			query = "";

			for (String badQualityContainerID : tableBadQualityContainerIDs) {
				Container c = new Container(badQualityContainerID, 0, 0);

				badQualityContainers.add(c);
			}

			for (Container c : badQualityContainers) {
				query = "INSERT INTO badqualitycontainer VALUES ('" + c.getContainer_id() + "', " + c.getProduct_id()
						+ ", " + c.getAmount() + ")";

				stmt.executeQuery(query);
			}

			OracleDB.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method that creates the data for the table wrong product container (container
	 * id, product id, amount) and fills it into a list The data from the list is
	 * then directly put onto the database
	 */
	public static void generateTableWrongProductContainer() {
		wrongProductContainers = new ArrayList<Container>();
		tableWrongProductContainerIDs = WrongProductContainer.getWrongProductContainerIDs();

		try {
			OracleDB.connect();

			stmt = OracleDB.getConnection().createStatement();
			query = "";

			for (String wrongProductContainerID : tableWrongProductContainerIDs) {
				Container c = new Container(wrongProductContainerID, 0, 0);

				wrongProductContainers.add(c);
			}

			for (Container c : wrongProductContainers) {
				query = "INSERT INTO wrongproductcontainer VALUES ('" + c.getContainer_id() + "', " + c.getProduct_id()
						+ ", " + c.getAmount() + ")";

				stmt.executeQuery(query);
			}

			OracleDB.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method that creates the data for the table package (package id, pallet id,
	 * product id, amount, container id) and fills it into a list The data from the
	 * list is then directly put onto the database
	 */
	public static void generateTablePackage() {
		packageIDs = Package.getPackageIDs();
		palletIDs = Pallet.getPalletIDs();
		tableProductAmounts = new ArrayList<Integer>();
		tablePalletIDs = new ArrayList<String>();
		tableProductIDs = new ArrayList<Integer>();
		tableContainerIDs = new ArrayList<String>();
		packages = new ArrayList<Package>();
		List<Integer> finalTableProductID = new ArrayList<>();

		random = new Random();

		try {
			OracleDB.connect();

			stmt = OracleDB.getConnection().createStatement();
			query = "";

			// Generate tablePackageAmounts
			/*for (String packageID : packageIDs) {
				tableProductAmounts.add(RandomGaussian.getRandomGaussian(50, 49));
			}*/
			
			for(int i = 0; i<packageIDs.size(); i++) {
				int temp = RandomGaussian.getRandomGaussian(50, 49);
				if (temp >= 1) {
					if(temp <= 99) {
						tableProductAmounts.add(temp);
					}
					else {
						i--;
					}
				}
				else {
					i--;
				}
			}

			// Generate tablePalletIDs
			for (String palletID : packageIDs) {
				tablePalletIDs.add(palletIDs.get(random.nextInt(palletIDs.size())));
			}
			
			

			Collections.sort(tablePalletIDs);

			// Generate tableProductIDs
			/*for (String productID : packageIDs) {
				int id = RandomGaussian.getRandomGaussian(25, 25);

				tableProductIDs.add(id);
			}*/
			
			for(int i = 0; i<packageIDs.size(); i++) {
				int temp = RandomGaussian.getRandomGaussian(25, 25);
				if (temp >= 1) {
					if(temp <= 50) {
						tableProductIDs.add(temp);
					}
					else {
						i--;
					}
				}
				else {
					i--;
				}
			}

			// Generate tableContainerIDs
			// For the same products on the same pallets, the container ID is the same.
			String temp; // The String in which the generated container id is later put in
			List<String> tempListPalletIDs; // A temporary list in which the same pallet IDs are stored
			List<Integer> tempListProductIDs; // A temporary list in which the product IDs of the same pallets are
												// stored

			int j = 0; // The counter for the first while loop
			int k = 0; // The counter which is raised when the same pallet IDs. Counter j is later
						// replaced with the value of k, because it needs to skip the same pallet IDs.
			int n = 0; // The counter which needs to constantly be raised to get the product IDs from
						// the table into the temporary product ID list in specific intervals.
			while (j < packageIDs.size()) {
				// The temporary lists need to be initialized every time the while loop starts
				tempListPalletIDs = new ArrayList<>();
				tempListProductIDs = new ArrayList<>();

				// The temporary pallet ID list is filled with the same pallet IDs and the k
				// counter is raised for every equal pallet id
				for (int i = 0; i < packageIDs.size(); i++) {

					if ((tablePalletIDs.get(j)).equalsIgnoreCase(tablePalletIDs.get(i))) {
						tempListPalletIDs.add(tablePalletIDs.get(i));
						k++;
					}
				}

				// The temporary product list is filled with the products from the pallets of
				// the temporary pallet list
				for (int i = 0; i < tempListPalletIDs.size(); i++) {
					tempListProductIDs.add(tableProductIDs.get(n));
					n++;
				}

				// The product IDs of every pallet need to be sorted
				Collections.sort(tempListProductIDs);

				// The sorted products are then added to a list which includes all products,
				// which is later put on the database
				for (int number : tempListProductIDs) {
					finalTableProductID.add(number);
				}

				int l = 0; // Counter for the second while loop, that goes through the temporary product
							// list
				int m = 0; // Counter which is raised for every equal product ID, whose value is later
							// applied to counter l to skip the same product IDs

				while (l < tempListProductIDs.size()) {
					boolean notContains = false;
					temp = bigContainerIDList.get(random.nextInt(bigContainerIDList.size())); // Generating the
																								// container ID

					// An if to check if a container ID is already present in the list.
					// The same product IDs on the same pallet are allowed to have the same
					// container id but this id is not allowed to be applied to other products of
					// other pallets.
					while (notContains == false) {
						if (!tableContainerIDs.contains(temp)) {
							notContains = true;
						} else {
							temp = bigContainerIDList.get(random.nextInt(bigContainerIDList.size()));
						}
					}

					// The container IDs are applied to every product and the same products on the
					// same pallets will have the same container IDs applied.
					for (int i = 0; i < tempListProductIDs.size(); i++) {
						if (tempListProductIDs.get(i) == tempListProductIDs.get(l)) {
							tableContainerIDs.add(temp);
							m++;
						}
					}
					l = m;
				}
				j = k;
			}

			// Old method of generating the container IDs
			// Creates one unique container for every product on every pallet
			////////////////////////
			/*
			 * for(int i = 0; i<packageIDs.size(); i++) { temp =
			 * bigContainerIDList.get(random.nextInt(bigContainerIDList.size()));
			 * 
			 * 
			 * 
			 * if(!tableContainerIDs.contains(temp)) { tableContainerIDs.add(temp); } else {
			 * i--; } }
			 * 
			 * 
			 * Collections.sort(tableContainerIDs);
			 */

			////////////////////////////

			for (int i = 0; i < packageIDs.size(); i++) {
				String tablePackageID = packageIDs.get(i);
				String tablePalletID = tablePalletIDs.get(i);
				int tableProductID = finalTableProductID.get(i);
				int tableProductAmount = tableProductAmounts.get(i);
				String tableContainerID = tableContainerIDs.get(i);

				Package p = new Package(tablePackageID, tablePalletID, tableProductID, tableProductAmount,
						tableContainerID);

				packages.add(p);
			}

			for (Package p : packages) {
				query = "INSERT INTO package VALUES ('" + p.getPackage_id() + "', '" + p.getPallet_id() + "', "
						+ p.getProduct_id() + ", " + p.getAmount() + ", '" + p.getContainer_id() + "')";

				stmt.executeQuery(query);
			}

			OracleDB.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
