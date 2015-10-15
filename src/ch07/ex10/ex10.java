package ch07.ex10;

import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class ex10 extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Random rnd = new Random();

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("A3横", rnd.nextInt(100)), new PieChart.Data("A3縦", rnd.nextInt(100)),
				new PieChart.Data("A4横", rnd.nextInt(100)), new PieChart.Data("A4縦", rnd.nextInt(100)),
				new PieChart.Data("B4横", rnd.nextInt(100)), new PieChart.Data("B4縦", rnd.nextInt(100)));
		PieChart chart = new PieChart(pieChartData);

		Scene scene = new Scene(new Group());
		((Group) scene.getRoot()).getChildren().add(chart);
		stage.setWidth(500);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.show();
	}
}
