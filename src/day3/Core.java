package day3;

import java.util.ArrayList;

public class Core {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		part1and2();
		System.out.println("Time passed: " + (System.currentTimeMillis() - time) + "ms");
	}

	public static void part1and2() {
		int[][] fabric = new int[1000][1000];
		ArrayList<String> input = Input.getContestInput("day3");
		for(String line : input) {
			String[] inputParts = line.split(" ");
			
			String[] xyPos = inputParts[2].split(",");
			int xPos = Integer.parseInt(xyPos[0]); 
			int yPos = Integer.parseInt(xyPos[1].replace(":", ""));
			
			String[] xyLen = inputParts[3].split("x");
			int xLen = Integer.parseInt(xyLen[0]);
			int yLen = Integer.parseInt(xyLen[1]);
			
			for(int x = 0; x < xLen; x++) {
				for(int y = 0; y < yLen; y++) {
					fabric[xPos + x][yPos + y] = fabric[xPos +x][yPos + y] + 1;
				}
			}
		}
		
		int free = 0;
		for(int i = 0; i < fabric.length; i++) {
			for(int x = 0; x < fabric[0].length; x++) {
				if(fabric[i][x] >= 2) {
					free++;
				}
			}
		}
		
		System.out.println("P1: " + free);
		
		
		for(String line : input) {
			String[] inputParts = line.split(" ");
			
			String[] xyPos = inputParts[2].split(",");
			int xPos = Integer.parseInt(xyPos[0]); 
			int yPos = Integer.parseInt(xyPos[1].replace(":", ""));
			
			String[] xyLen = inputParts[3].split("x");
			int xLen = Integer.parseInt(xyLen[0]);
			int yLen = Integer.parseInt(xyLen[1]);
			
			String claim = inputParts[0].replace("#", "");
			boolean found = true;
			for(int x = 0; x < xLen; x++) {
				for(int y = 0; y < yLen; y++) {
					fabric[xPos + x][yPos + y] = fabric[xPos +x][yPos + y] + 1;
					if(fabric[xPos + x][yPos + y] != 2) {
						found = false;
					}
				}
			}
			if(found) {
				System.out.println("P2: " + claim);
			}
		}
		
	}
}
