package video03;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Dinosaur extends Pane {

	Circle head, eyeLeft, eyeRight;
	Ellipse head2, mouth, body;
	Rectangle neck, frontRLeg, frontLLeg, backRLeg, backLLeg, tail;
	
	public Dinosaur() {
		this.setBackground(new Background(new BackgroundFill(Color.RED,null, null)));
		
		head = new Circle(100, 50, 50);
		head.setFill(Color.GREEN);
		head.setStroke(Color.BLACK);
		
		head2 = new Ellipse(70, 70, 70, 40);
		head2.setFill(Color.GREEN);
		head2.setStroke(Color.BLACK);
		
		eyeLeft = new Circle(70, 30, 10);
		eyeRight = new Circle(90, 30, 10);
		mouth = new Ellipse(50, 70, 30, 2);
		
		neck = new Rectangle(100, 70, 50, 150);
		neck.setFill(Color.GREEN);
		neck.setStroke(Color.BLACK);
		neck.setRotate(-20);
		
		body = new Ellipse(300, 250, 200, 100);
		body.setFill(Color.GREEN);
		body.setStroke(Color.BLACK);
		
		frontRLeg = new Rectangle(150, 290, 50, 150);
		frontRLeg.setFill(Color.DARKGREEN);
		frontRLeg.setStroke(Color.BLACK);
		
		frontLLeg = new Rectangle(170, 300, 50, 150);
		frontLLeg.setFill(Color.GREEN);
		frontLLeg.setStroke(Color.BLACK);
		
		backRLeg = new Rectangle(350, 290, 50, 150);
		backRLeg.setFill(Color.DARKGREEN);
		backRLeg.setStroke(Color.BLACK);
		
		backLLeg = new Rectangle(370, 300, 50, 150);
		backLLeg.setFill(Color.GREEN);
		backLLeg.setStroke(Color.BLACK);
		
		tail = new Rectangle(400, 300, 200, 20);
		tail.setFill(Color.GREEN);
		tail.setStroke(Color.BLACK);
		tail.setRotate(50);
		
		this.getChildren().addAll(
				neck,
				head,
				eyeLeft,
				head2,
				eyeRight,
				mouth,
				frontRLeg,
				backRLeg,
				tail,
				body,
				frontLLeg,
				backLLeg
				);
	}
	
}
