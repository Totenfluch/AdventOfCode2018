package day4;

import java.util.ArrayList;

public class Guard {
	private int id;
	private boolean isAwake;
	int shiftStart = 0;
	int lastAsleep = -1;
	
	int mostAsleep = 0;
	int totalAsleep = 0;
	int mostFrequentlyAsleep = 0;

	int[] totalShifTime = new int[60];
	ArrayList<int[]> shifts = new ArrayList<int[]>();

	public Guard(int id) {
		this.id = id;
		this.isAwake = true;
	}

	public void beginShift(String timestamp) {
		int shiftStart = Integer.parseInt(timestamp.split(" ")[1].replace("]", "").split(":")[1]);
		this.shifts.add(new int[60]);
		this.shiftStart = shiftStart;
		this.isAwake = true;
	}

	public void wake(String timestamp) {
		int lastAwake = Integer.parseInt(timestamp.split(" ")[1].replace("]", "").split(":")[1]);
		if(!this.isAwake) {
			for(int i = this.lastAsleep; i < lastAwake; i++) {
				this.shifts.get(shifts.size() - 1)[i]++;
				this.totalShifTime[i]++;
				this.totalAsleep++;
			}
			this.isAwake = true;
		}
	}

	public void sleep(String timestamp) {
		int asleep = Integer.parseInt(timestamp.split(" ")[1].replace("]", "").split(":")[1]);
		this.lastAsleep = asleep;
		this.isAwake = false;
	}

	public void endShift(String timestamp) {
		if(!this.isAwake) {
			int endShift = Integer.parseInt(timestamp.split(" ")[1].replace("]", "").split(":")[1]);
			for(int i = this.lastAsleep; i < endShift; i++) {
				this.shifts.get(shifts.size() - 1)[i]++;
				this.totalShifTime[i]++;
				this.totalAsleep++;
			}
		}
		
		for(int i = 0; i < this.totalShifTime.length; i++) {
			if(this.totalShifTime[i] > this.totalShifTime[this.mostAsleep]) {
				this.mostAsleep = i;
			}
		}
		
		for(int i = 0; i < this.totalShifTime.length; i++) {
			if(this.totalShifTime[i] > this.mostFrequentlyAsleep) {
				this.mostFrequentlyAsleep = this.totalShifTime[i];
			}
		}
	}
	
	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		return ((Guard) o).id == this.id;
	}
}
