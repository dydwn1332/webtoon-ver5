package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene1;
	Scene scene2;
	Scene scene3;

	@Override
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			window.setResizable(false);
			AnchorPane root1 = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));
			AnchorPane root2 = (AnchorPane) FXMLLoader.load(getClass().getResource("sub.fxml"));
			AnchorPane root3 = (AnchorPane) FXMLLoader.load(getClass().getResource("comment.fxml"));
			Button main = new Button("메인");
			main.setPrefWidth(80);
			main.setLayoutX(10);
			main.setLayoutY(10);
			Button sub = new Button("이미지보기");
//			sub.setPrefWidth(80);
//			sub.setLayoutX(100);
//			sub.setLayoutY(10);
			sub.setPrefWidth(80);
			sub.setLayoutX(190);
			sub.setLayoutY(10);
			
			Button comment = new Button("댓글");
//			comment.setPrefWidth(80);
//			comment.setLayoutX(190);
//			comment.setLayoutY(10);
			comment.setPrefWidth(80);
			comment.setLayoutX(100);
			comment.setLayoutY(10);

			scene1 = new Scene(root1);
			scene2 = new Scene(root2);
			scene3 = new Scene(root3);

			main.setOnAction(e -> {
				root1.getChildren().addAll(main, sub, comment);
				window.setScene(scene1);
			});
			sub.setOnAction(e -> {
				root2.getChildren().addAll(main, sub, comment);
				window.setScene(scene2);
			});
			comment.setOnAction(e -> {
				root3.getChildren().addAll(main, sub, comment);
				window.setScene(scene3);
			});

			root1.getChildren().addAll(main, sub, comment);

			window.setTitle("네이버웹툰크롤링");
			window.setScene(scene1);
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	

}
