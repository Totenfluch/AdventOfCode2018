package day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Input {
	private static final ArrayList<String> contestInput = new ArrayList<String>();
	
	public static void resolveFile(String day) {
		try(BufferedReader br = new BufferedReader(new FileReader("src/" + day + "/input.txt"))) {
			String line;
			while((line = br.readLine()) != null) {
				contestInput.add(line);
			}
			Collections.sort(contestInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<String> getContestInput(String day) {
		if(contestInput.size() == 0) {
			Input.resolveFile(day);
		}
		return contestInput;
	}
	
}
