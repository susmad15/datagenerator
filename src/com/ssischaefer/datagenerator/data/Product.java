package com.ssischaefer.datagenerator.data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

//Data class for the table products
public class Product {

	private int id;
	private String name;
	private String image;

	private static List<BufferedImage> productproductNames;
	private static List<String> productImagePaths;

	private static List<String> productNames;

	//The table packages consists of the product ID, the product name and the product image
	public Product(int id, String name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}

	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	// Method that creates a list of image paths
	private static void generateProductImages() {
		productproductNames = new ArrayList<BufferedImage>();
		productImagePaths = new ArrayList<String>();

		//50 image paths are put in list
		for (int i = 1; i <= 50; i++) {
			String path = "resources/products/" + i + ".png";

			productImagePaths.add(path);

			try {
				productproductNames.add(ImageIO.read(new File(path)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<BufferedImage> getProductproductNames() {
		generateProductImages();

		return productproductNames;
	}

	public static List<String> getProductproductNamesPath() {
		generateProductImages();

		return productImagePaths;
	}
	
	//Method that adds 50 product names to a list
	private static void generateProductNames() {
		productNames = new ArrayList<String>();
		
		productNames.add("Pepsi Dose");
        productNames.add("Muesli");
        productNames.add("Muesli Riegel");
        productNames.add("Insektizid");
        productNames.add("Kaffeekanne");
        productNames.add("Boxen");
        productNames.add("Kokosnuss Oel");
        productNames.add("Handrasierer");
        productNames.add("Babyoel");
        productNames.add("Aloe Vera");
        productNames.add("Kopfhoerer");
        productNames.add("Wasser");
        productNames.add("Deo Stick");
        productNames.add("Waschmittel");
        productNames.add("Zitronenwasser");
        productNames.add("Cheetos");
        productNames.add("Collagen");
        productNames.add("Webcam");
        productNames.add("Dove Men and Care");
        productNames.add("Drone");
        productNames.add("Kocher");
        productNames.add("Wireless Kopfhoerer");
        productNames.add("Steelseries Kopfhörer");
        productNames.add("Energieriegel");
        productNames.add("Proteinpulver");
        productNames.add("Google Chromecast");
        productNames.add("HTC Vive");
        productNames.add("Kokosmilch");
        productNames.add("Scheinwerfer");
        productNames.add("Huawei Tablet");
        productNames.add("Mascara");
        productNames.add("Makeup Kit");
        productNames.add("Textmarker");
        productNames.add("Ketones");
        productNames.add("Mountain Dew");
        productNames.add("Feuchttücher");
        productNames.add("Lautsprecher");
        productNames.add("Ofen");
        productNames.add("Felgen");
        productNames.add("Wasserkocher");
        productNames.add("Elektrischer Rasierer");
        productNames.add("Reiniger");
        productNames.add("Shampoo");
        productNames.add("Beats");
        productNames.add("Surface");
        productNames.add("Uhr");
        productNames.add("Orangensaft");
        productNames.add("Red Bull");
        productNames.add("Chips");
        productNames.add("Kamera");
	}
	
	//Returns product names
	public static List<String> getProductNames() {
		generateProductNames();
		
		return productNames;
	}

}
