package com.internet.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {
	public static String generateRandomInput() {
		String input = RandomStringUtils.randomNumeric(3);
		
		return input;
	}

}