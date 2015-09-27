package ch04.ex09;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotationAnimation extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		int circleSize = 10;
		int stageSize = 500;
		//円（太陽）をシーンの中心に配置する。
		Circle sun = new Circle(circleSize);
		sun.setFill(Color.RED);
		sun.centerXProperty().bind(Bindings.divide(stage.widthProperty(), 2));
		sun.centerYProperty().bind(Bindings.divide(stage.heightProperty(), 2));
		//もう一つ円（地球）を作成。
		Circle earth = new Circle(circleSize);
		earth.setFill(Color.BLUE);
		//楕円上の軌道を作成する
		Ellipse ellipse = new Ellipse();
		ellipse.setCenterX(stageSize / 2);
		ellipse.setCenterY(stageSize / 2);
		ellipse.setRadiusX(200);
		ellipse.setRadiusY(150);
		//地球を軌道に乗せる。
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(3000));
		pt.setNode(earth);
		pt.setPath(ellipse);
		pt.setCycleCount(Animation.INDEFINITE);
		pt.setInterpolator(Interpolator.LINEAR);
		pt.play();

		stage.setScene(new Scene(new Pane(sun, earth), stageSize, stageSize));
		stage.setResizable(false);//リサイズを禁止する。（アニメーションが崩れてしまう。）
		stage.show();
	}

}