package day3;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Visual extends Application{

	public static int[][] fabric;

	public static void main(String[] args) {
		fabric = new int[1000][1000];
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
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene s = new Scene(root, 1000, 1000, Color.WHITE);

		final Canvas canvas = new Canvas(1000, 1000);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		for(int i = 0; i < fabric.length; i++) {
			for(int x = 0; x < fabric[0].length; x++) {
				switch(fabric[i][x]) {
				case 0: break;
				case 1: gc.setFill(Color.BLACK); gc.fillRect(i, x, 1, 1); break;
				case 2: gc.setFill(Color.GREEN); gc.fillRect(i, x, 1, 1); break;
				case 3: gc.setFill(Color.YELLOW); gc.fillRect(i, x, 1, 1); break;
				case 4: gc.setFill(Color.AZURE); gc.fillRect(i, x, 1, 1); break;
				case 5: gc.setFill(Color.RED); gc.fillRect(i, x, 1, 1); break;
				}
			}
		}

		root.getChildren().add(canvas);

		primaryStage.setScene(s);
		primaryStage.show();

	}
}
