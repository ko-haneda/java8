package ch03.ex08;

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

	public static <T> Image transform(Image in, ColorTransformer c) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, c.apply(x, y, in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
	}

	public static ColorTransformer colorTransformer(double width, double height, int frameWidth, Color frameColor){
		return (x, y, c) -> {
			if (x < frameWidth || x > width - frameWidth || y < frameWidth || y > height - frameWidth)	return frameColor;
			else return c;
		};
	}

	public void start(Stage arg0) throws Exception {
		Image in = new Image("file:./src/ch03/ex08/sample.png");
		Image out = transform(in, colorTransformer(in.getWidth(), in.getHeight(), 10, Color.GRAY));
		arg0.setScene(new Scene(new HBox(new ImageView(in), new ImageView(out))));
		arg0.show();
	}
}
