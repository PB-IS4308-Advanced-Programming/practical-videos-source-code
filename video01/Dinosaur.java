package video01;

import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class Dinosaur extends Pane {

	public Dinosaur() {
		Circle circle = new Circle(100, 50, 50);
		
		Ellipse ellipse = new Ellipse(70, 70, 70, 40);
		
		this.getChildren().addAll(circle, ellipse);
	}
	
}
