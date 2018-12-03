package day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Core {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println("P1: " + part1());
		System.out.println("P2: " + part2());
		System.out.println("Time passed: " + (System.currentTimeMillis() - time) + "ms");
	}

	public static int part1() {
		ArrayList<String> input = Input.getContestInput("day2");
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();

		int two = 0;
		int three = 0;
		for(int i = 0; i < input.size(); i++) {
			char[] cInput = input.get(i).toCharArray();
			for(int x = 0; x < cInput.length; x++) {
				Integer cCount = count.get(cInput[x]);
				Integer val = cCount == null ? 1 : (cCount + 1);
				count.put(cInput[x], val);
			}

			two += count.values().stream().anyMatch(n -> n == 2) ? 1 : 0;
			three += count.values().stream().anyMatch(n -> n == 3) ? 1 : 0;
			count.clear();
		}

		return two * three;
	}

	public static String part2() {
		ArrayList<char[]> input = Input.getContestInput("day2").stream().map(string -> string.toCharArray()).collect(Collectors.toCollection(ArrayList::new));

		for(int i = 0; i < input.size() - 1; i++) {
			char[] currTest = input.get(i);
			for(int w = i; w < input.size() - 1; w++) {
				char[] nextTest = input.get(w + 1);
				int skip = 0;
				int skipL = 0;
				for(int x = 0; x < currTest.length; x++) {
					if(currTest[x] != nextTest[x]) {
						if(skip > 1)
							continue;
						else 
							skipL = x;
						skip++;
					}
				}
				if(skip <= 1) {
					String result = "";
					for(int z = 0; z < currTest.length; z++) {
						if(z != skipL)
							result += currTest[z];
					}
					return result;
				}
			}	
		}
		return "";
	}
}
