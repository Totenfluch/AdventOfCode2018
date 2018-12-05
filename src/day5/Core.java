package day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Core {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		part1and2();
		System.out.println("Time passed: " + (System.currentTimeMillis() - time) + "ms");
	}

	public static void part1and2() {
		System.out.println((int)'a' + " " + (int)'z');
		ArrayList<Character> input = new ArrayList<Character>();
		char[] in = Input.getContestInput("day5").get(0).toCharArray();
		for(int i = 0; i < in.length; i++) {
			input.add(in[i]);
		}

		int start = 97;
		int end = 122;


		ArrayList<Character> cpinput = new ArrayList<Character>();
		for(Character c : input) {
			cpinput.add(c);
		}
		
		
		for(int n = start; n <= end; n++) {
			input.clear();
			for(Character c : cpinput) {
				input.add(c);
			}
			
			Character c1 = (char)n;
			Character c2 = (char)(n-32);
			for(int w = 0; w < input.size(); w++) {
				input.remove(c1);
				input.remove(c2);
			}
			System.out.println(input.size());
			
			int changes = 1;
			while(true) {
				changes = 0;
				for(int i = 0; i < input.size() - 1; i++) {
					if(Math.abs((int)input.get(i) - (int)input.get(i + 1)) == 32) {
						input.remove(i + 1);
						input.remove(i);
						changes++;
					}
				}
				if(changes == 0)
					break;
			}
			System.out.println("(" + (char)n + "/" + (char)(n - 32) + ") P2: " + input.size());
		}

	}
}
