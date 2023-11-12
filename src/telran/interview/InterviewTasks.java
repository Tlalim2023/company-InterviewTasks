package telran.interview;

import java.util.*;

public class InterviewTasks {
	/**
	 *
	 * @param ar array of integer numbers
	 * @param sum integer number
	 * @return true if the given array contains two numbers, the sum of which equals the given sum value
	 */
	public static boolean isSum2(int [] ar, int sum) {
		List <Integer> list = new ArrayList<>();
		for(var t: ar){
			list.add(t);
		}
		for (var number: list){
			if(list.contains(sum - number)){
				return true;
			}
		}

		return false;
	}
	/**
	 *
	 * @param ar array of integer numbers
	 * @return maximal positive number having negative number with the same absolute value
	 */
	public static int getMaxPositiveWithNegativeValue (int ar[]) {
		int min = Integer.MIN_VALUE;
		List <Integer> list = new ArrayList<>();
		for(var t: ar){
			list.add(t);
		}
		Collections.sort(list);

		for (var number: list){
			if(list.contains(number*(-1))){
				min = number;
				return min*(-1);
			}
		}
		//TODO should be done with O[N]
		return -1;
	}

	/**
	 *
	 * @param strings - array of strings
	 * @return Map where key - string, value - number of occurrences in the array
	 */
	public static HashMap<String, Long> getMapOccurrences(String[] strings) {

		HashMap<String, Long> map = new HashMap<>();

		for (String el : strings){
			map.merge(el, 1L, Long::sum);
		}
		if(!map.isEmpty()){
			return map;
		}
		return null;
	}
	/**
	 * Anagram of a string is another string containing all the symbols
	 * from the string, but in different order (see the test cases)
	 * @param string
	 * @param anagram
	 * @return true if the second parameter presents an anagram
	 *  of the string from the first parameter, otherwise false
	 */
	public static boolean isAnagram(String string, String anagram) {
		boolean isAnagram = false;

		var string1 = string.replaceAll("\\s", "").toLowerCase();
		var anagram1 = anagram.replaceAll("\\s", "").toLowerCase();

		if (string.length() != anagram.length() || string.equals(anagram)) {
			return false;
		}
		char[] first = string1.toCharArray();
		char[] second = anagram1.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);

		// Сравниваем отсортированные массивы
		isAnagram = Arrays.equals(first, second);

		return isAnagram;
	}

}