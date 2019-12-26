package com.ssischaefer.datagenerator.data;

import java.util.ArrayList;
import java.util.List;


// Class that adds URLs of 50 different images to a list and returns it

public class Image {

	private static List<String> imageURLs;

	private static void generateImageURLs() {
		imageURLs = new ArrayList<String>();
		
		imageURLs.add("https://i.ibb.co/HHDyqxg/1.png");
		imageURLs.add("https://i.ibb.co/6XLRcgL/2.png");
		imageURLs.add("https://i.ibb.co/9bsfjzZ/3.png");
		imageURLs.add("https://i.ibb.co/Jzw01zR/4.png");
		imageURLs.add("https://i.ibb.co/D4Vqkk1/5.png");
		imageURLs.add("https://i.ibb.co/1dtB050/6.png");
		imageURLs.add("https://i.ibb.co/mh907J7/7.png");
		imageURLs.add("https://i.ibb.co/f1WsqjF/8.png");
		imageURLs.add("https://i.ibb.co/MMVvTpp/9.png");
		imageURLs.add("https://i.ibb.co/qdns0kc/10.png");
		imageURLs.add("https://i.ibb.co/Zm3ghJH/11.png");
		imageURLs.add("https://i.ibb.co/vm2bLZb/12.png");
		imageURLs.add("https://i.ibb.co/N9MZVsD/13.png");
		imageURLs.add("https://i.ibb.co/mqmyf3X/14.png");
		imageURLs.add("https://i.ibb.co/W5SQSjM/15.png");
		imageURLs.add("https://i.ibb.co/1R2QVKL/16.png");
		imageURLs.add("https://i.ibb.co/1K0y8mj/17.png");
		imageURLs.add("https://i.ibb.co/0XLRKJY/18.png");
		imageURLs.add("https://i.ibb.co/d6YWn8m/19.png");
		imageURLs.add("https://i.ibb.co/rZ6SBxq/20.png");
		imageURLs.add("https://i.ibb.co/X2ksFQ8/21.png");
		imageURLs.add("https://i.ibb.co/VV4T0Ss/22.png");
		imageURLs.add("https://i.ibb.co/vdbB3Xg/23.png");
		imageURLs.add("https://i.ibb.co/kyX77j5/24.png");
		imageURLs.add("https://i.ibb.co/gv9szsb/25.png");
		imageURLs.add("https://i.ibb.co/mGHf4SR/26.png");
		imageURLs.add("https://i.ibb.co/qpMxRnJ/27.png");
		imageURLs.add("https://i.ibb.co/Pt3N0fz/28.png");
		imageURLs.add("https://i.ibb.co/QQHzJvh/29.png");
		imageURLs.add("https://i.ibb.co/1sKm2QR/30.png");
		imageURLs.add("https://i.ibb.co/ZTX3nzj/31.png");
		imageURLs.add("https://i.ibb.co/kQdP8wW/32.png");
		imageURLs.add("https://i.ibb.co/rM6kQHS/33.png");
		imageURLs.add("https://i.ibb.co/RCjt189/34.png");
		imageURLs.add("https://i.ibb.co/19L941S/35.png");
		imageURLs.add("https://i.ibb.co/7YgcgRL/36.png");
		imageURLs.add("https://i.ibb.co/ZLc3RND/37.png");
		imageURLs.add("https://i.ibb.co/N2NBdZn/38.png");
		imageURLs.add("https://i.ibb.co/QD6J3VS/39.png");
		imageURLs.add("https://i.ibb.co/PQggDK4/40.png");
		imageURLs.add("https://i.ibb.co/HYxQtVn/41.png");
		imageURLs.add("https://i.ibb.co/Tqh7Hm0/42.png");
		imageURLs.add("https://i.ibb.co/pbXcyrw/43.png");
		imageURLs.add("https://i.ibb.co/xhJKG7f/44.png");
		imageURLs.add("https://i.ibb.co/6tyxLxf/45.png");
		imageURLs.add("https://i.ibb.co/myM18YK/46.png");
		imageURLs.add("https://i.ibb.co/bv9J63s/47.png");
		imageURLs.add("https://i.ibb.co/VqJS5hS/48.png");
		imageURLs.add("https://i.ibb.co/0K5hTdb/49.png");
		imageURLs.add("https://i.ibb.co/zbwBSgv/50.png");
	}
	
	//Returns the list of URLs
	public static List<String> getImageURLs() {
		generateImageURLs();
		
		return imageURLs;
	}

}
