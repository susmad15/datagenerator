package com.ssischaefer.datagenerator.main;

import com.ssischaefer.datagenerator.database.controller.TableController;

public class App {
	
	//Main method that executes the generate methods of the TableController class
	public static void main(String[] args) {
		TableController.generateTableProduct();
		TableController.generateTableContainer();
		TableController.generateTableBadQualityContainer();
		TableController.generateTableWrongProductContainer();
		TableController.generateTablePackage();
	}
	
}
