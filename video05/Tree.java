package video05;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Tree extends Pane {
	
	Polygon leaf1, leaf2, leaf3, leaf4, leaf5, trunk;
	
	public Tree() {
		this.setBackground(new Background(new BackgroundFill(Color.BLUE,null, null)));
		
		leaf1 = new Polygon();
		leaf1.getPoints().addAll(
				65.0, 50.0,
				45.0, 60.0,
				20.0, 100.0,
				45.0, 90.0
				);
		leaf1.setFill(Color.GREEN);
		leaf1.setStroke(Color.BLACK);
		leaf1.setStrokeWidth(2);
		
		leaf2 = new Polygon();
		leaf2.getPoints().addAll(
				65.0, 50.0,
				30.0, 60.0,
				5.0, 40.0
				);
		leaf2.setFill(Color.GREEN);
		leaf2.setStroke(Color.BLACK);
		leaf2.setStrokeWidth(2);
		
		leaf3 = new Polygon();
		leaf3.getPoints().addAll(
				65.0, 50.0,
				85.0, 60.0,
				115.0, 100.0,
				85.0, 90.0
				);
		leaf3.setFill(Color.GREEN);
		leaf3.setStroke(Color.BLACK);
		leaf3.setStrokeWidth(2);

		leaf4 = new Polygon();
		leaf4.getPoints().addAll(
				65.0, 50.0,
				100.0, 60.0,
				130.0, 40.0
				);
		leaf4.setFill(Color.GREEN);
		leaf4.setStroke(Color.BLACK);
		leaf4.setStrokeWidth(2);
		
		leaf5 = new Polygon();
		leaf5.getPoints().addAll(
				65.0, 50.0,
				45.0, 40.0,
				40.0, 0.0,
				70.0, 30.0
				);
		leaf5.setFill(Color.GREEN);
		leaf5.setStroke(Color.BLACK);
		leaf5.setStrokeWidth(2);
		
		trunk = new Polygon();
		trunk.getPoints().addAll(
				65.0, 50.0,
				0.0, 500.0,
				130.0, 500.0
				);
		trunk.setFill(Color.BROWN);
		trunk.setStroke(Color.DARKRED);
		trunk.setStrokeWidth(4);
		
		this.getChildren().addAll(
				trunk,
				leaf1,
				leaf2,
				leaf3,
				leaf4,
				leaf5
				);
	}

}
