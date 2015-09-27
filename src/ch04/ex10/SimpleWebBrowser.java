package ch04.ex10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * 
 * TODO　
 * ①ページが更新されたらURLを追加する処理
 * ②戻るボタンが押されたらURLを追加する処理
 * 
 * @author haneda
 *
 */
public class SimpleWebBrowser extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Button backButton = new Button("←");
		backButton.setMinWidth(60);
		
		String URL = "http://www.google.com/";
		TextField urlText = new TextField(URL);
		urlText.prefWidthProperty().bind(stage.widthProperty());
		
		WebView browser = new WebView();
		WebEngine engine = browser.getEngine();
		engine.load(URL);
		
		//戻るボタンの処理
		backButton.setOnAction(e -> {
			WebHistory history = engine.getHistory();
			if (history.getCurrentIndex() != 0) {
				history.go(-1);
				//TODO
			}
		});
		//URLバーの処理
		urlText.setOnAction(e -> engine.load(urlText.getText()));
		
		//TODO ページが更新されたらURLを追記する処理
		
		
		HBox toolBar = new HBox(backButton, urlText);
		VBox all = new VBox(toolBar, browser);
		stage.setScene(new Scene(all));
		stage.show();
	}

}