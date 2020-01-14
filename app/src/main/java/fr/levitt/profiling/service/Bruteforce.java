package fr.levitt.profiling.service;

import java.util.Random;

public class Bruteforce {
	
	public static String testRandomHashes(String hashToTest) {
		for (int i = 0; i < 1000*1000; i++) {
			String sourceToTest = generateRandomInput();
			if (Hasher.applySha256(sourceToTest) != null && Hasher.applySha256(sourceToTest).equals(hashToTest)) {
				return sourceToTest;
			}
		}
		return null;
	}

	private static String generateRandomInput() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();

		return generatedString;
	}
}
