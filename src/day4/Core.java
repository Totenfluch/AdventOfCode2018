package day4;

import java.util.ArrayList;

public class Core {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		part1and2();
		System.out.println("Time passed: " + (System.currentTimeMillis() - time) + "ms");
	}

	public static void part1and2() {
		ArrayList<String> input = Input.getContestInput("day4");
		ArrayList<Guard> guards = new ArrayList<Guard>();

		int guardId = -1;
		for(String line : input) {
			if(line.contains("Guard")) {
				if(guardId != -1) {
					guards.get(guards.indexOf(new Guard(guardId))).endShift(line);
				}
				guardId = Integer.parseInt(line.split(" ")[3].replace("#", ""));
			}
			
			if(guardId == -1) {
				continue;
			}

			int guardPos = guards.indexOf(new Guard(guardId));
			Guard currGuard;
			if(guardPos != -1) {
				currGuard = guards.get(guardPos);
			} else {
				currGuard = new Guard(guardId);
				guards.add(currGuard);
			}

			if(line.contains("wakes up")) {
				currGuard.wake(line);
			} else if(line.contains("begins shift")) {
				currGuard.beginShift(line);
			} else if(line.contains("falls asleep")) {
				currGuard.sleep(line);
			}

			if(guardId == 0) {
				continue;
			}
		}
		
		int guardMaxTotalAsleep = -1;
		Guard guardMaxTotalAsleepObj = null;
		for(Guard g : guards) {
			if(g.totalAsleep > guardMaxTotalAsleep) {
				guardMaxTotalAsleep = g.totalAsleep;
				guardMaxTotalAsleepObj = g;
			}
		}
	
		int guardMostFrequentlyAsleep = -1;
		Guard guardMostFrequentlyAsleepObj = null;
		for(Guard g : guards) {
			if(g.mostFrequentlyAsleep > guardMostFrequentlyAsleep) {
				guardMostFrequentlyAsleep = g.mostFrequentlyAsleep;
				guardMostFrequentlyAsleepObj = g;
			}
		}
		
		System.out.println("P1: " + guardMaxTotalAsleepObj.getId() * guardMaxTotalAsleepObj.mostAsleep);
		System.out.println("P2: " + guardMostFrequentlyAsleepObj.getId() * guardMostFrequentlyAsleepObj.mostAsleep);
	}
}
