package day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Core {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		ArrayList<Integer> intInput = Input.getContestInput("day1")
				.stream()
				.mapToInt(a -> Integer.parseInt(a))
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("P1: " + part1(intInput));
		System.out.println("P2: " + part2(intInput));
		System.out.println("Time passed: " + (System.currentTimeMillis() - time) + "ms");
	}
	
	public static int part1(ArrayList<Integer> intInput) {
		return intInput.stream().mapToInt(i -> i.intValue()).sum();
	}
	
	public static int part2(ArrayList<Integer> intInput) {
		HashSet<Integer> partResults = new HashSet<Integer>();
		int c = 0;
		while(true) {
			for(int i = intInput.size() - 1; i >= 0; i--) {
				if(partResults.contains(c += intInput.get(i))) return c;
				partResults.add(c);
			}
		}
	}
}
