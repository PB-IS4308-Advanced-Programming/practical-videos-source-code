package video01;

import javafx.application.Application;
import javafx.scene.Scene;
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
		
		world.getChildren().addAll(dino);
		
		Scene scene = new Scene(world, WIDTH, HEIGHT);
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
