package ch03.ex06;

import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TranceformerImage extends Application {

	public static void main(String[] args) {
		launch();
	}

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
			}
		}
		return out;
	}

	public void start(Stage arg0) throws Exception {
		Image in = new Image("file:./src/ch03/ex06/sample.png");
		//色相、彩度、明るさ、不透明度
//		Image out = transform(in, (c, factor) -> c.deriveColor(0.0, 1.0, factor, 1.0), 1.2);
		Image out = transform(in, (c, factor) -> c.deriveColor(0.0, 1.0, factor, 1.0), 0.5);
		arg0.setScene(new Scene(new HBox(new ImageView(in), new ImageView(out))));
		arg0.show();
	}
}
