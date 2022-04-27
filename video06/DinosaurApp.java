package video06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class DinosaurApp extends Application {

	final int WIDTH = 1280;
	final int HEIGHT = 720;
	double orgSceneX, orgSceneY;
	
	@Override
	public void start(Stage arg0) throws Exception {
		Pane world = new Pane();
		
		Dinosaur dino = new Dinosaur();
		dino.setLayoutX(500);
		dino.setLayoutY(0);
		
		Tree tree = new Tree();
		
		world.getChildren().addAll(tree, dino);
		
		dino.setOnMousePressed(e -> {
			orgSceneX = e.getSceneX();
			orgSceneY = e.getSceneY();
			
			dino.startWalking();
		});
		
		dino.setOnMouseReleased(e -> {
			dino.stopWalking();
		});
		
		dino.setOnMouseDragged(e -> {
			double offsetX = e.getSceneX() - orgSceneX;
			double offsetY = e.getSceneY() - orgSceneY;
			
			Dinosaur d = (Dinosaur) e.getSource();
			d.setLayoutX(d.getLayoutX() + offsetX);
			d.setLayoutY(d.getLayoutY() + offsetY);
			
			orgSceneX = e.getSceneX();
			orgSceneY = e.getSceneY();
			
			if(dino.getBoundsInParent().intersects(tree.getBoundsInParent())) {
				if(tree.noMoreLeafs() == false && dino.eating == false) {					
					dino.startEating();
					tree.removeLeaf();
				}
			} else {
				dino.stopEating();
			}
		});
		
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
				if(tree.noMoreLeafs() == false && dino.eating == false) {					
					dino.startEating();
					tree.removeLeaf();
				}
			} else {
				dino.stopEating();
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
