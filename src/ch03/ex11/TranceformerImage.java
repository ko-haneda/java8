package ch03.ex11;

import java.util.function.UnaryOperator;

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

	public static Image transform(Image in, ColorTransformer c) {
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

	public static ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
		return (x, y, c) -> f2.apply(x, y, f1.apply(x, y, c));
	}

	public static ColorTransformer toColorTransformer(UnaryOperator<Color> f) {
		return (x, y, color) -> f.apply(color);
	}

	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
	}

	public void start(Stage arg0) throws Exception {
		Image in = new Image("file:./src/ch03/ex11/sample.png");
		Image out = transform(in, compose(toColorTransformer(Color::brighter), (x, y, c) -> {
			if (x < 10 || x > in.getWidth() - 10 || y < 10 || y > in.getHeight() - 10)
				return Color.GRAY;
				else
					return c;
			}));
		arg0.setScene(new Scene(new HBox(new ImageView(in), new ImageView(out))));
		arg0.show();
	}
}
