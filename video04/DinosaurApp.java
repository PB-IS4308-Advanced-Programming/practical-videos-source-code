package video04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class DinosaurApp extends Application {

	final int WIDTH = 1280;
	final int HEIGHT = 720;
	
	@Override
	public void start(Stage arg0) throws Exception {
		Pane world = new Pane();
		
		Dinosaur dino = new Dinosaur();
		dino.setLayoutX(500);
		dino.setLayoutY(0);
		
		Tree tree = new Tree();
		
		world.getChildren().addAll(tree, dino);
		
		Scene scene = new Scene(world, WIDTH, HEIGHT);
		scene.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.A) {
				dino.setLayoutX(dino.getLayoutX() - 10);
				dino.moveLegs();
			}
			if(e.getCode() == KeyCode.D) {
				dino.setLayoutX(dino.getLayoutX() + 10);
				dino.moveLegs();
			}
			if(dino.getBoundsInParent().intersects(tree.getBoundsInParent())) {
				System.out.println("Eat the leafs");
			}
		});
		
		scene.setOnKeyReleased(e -> {
			
		});
		
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
