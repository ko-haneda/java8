package ch03.ex13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TranceformerImage extends Application {

	public static void main(String[] args) {
		launch();
	}
//
//	public static Image transform(Image in, ColorTransformer c) {
//		int width = (int) in.getWidth();
//		int height = (int) in.getHeight();
//		WritableImage out = new WritableImage(width, height);
//		for (int x = 0; x < width; x++) {
//			for (int y = 0; y < height; y++) {
//				out.getPixelWriter().setColor(x, y, c.apply(x, y, in.getPixelReader().getColor(x, y)));
//			}
//		}
//		return out;
//	}
//
//	public static ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
//		return (x, y, c) -> f2.apply(x, y, f1.apply(x, y, c));
//	}
//
//	public static ColorTransformer toColorTransformer(UnaryOperator<Color> f) {
//		return (x, y, color) -> f.apply(color);
//	}

	@FunctionalInterface
	public interface ColorTransformer {
		Color apply(int x, int y, Color colorAtXY);
	}

	public void start(Stage arg0) throws Exception {
		Image in = new Image("file:./src/ch03/ex13/sample.png");
		PixelWindow sobel = (x, y, window) ->{
			double r = (window[0][0].getRed() + 2 * window[0][1].getRed() + window[0][2].getRed() - 
						 window[2][0].getRed() - 2 * window[2][1].getRed() - window[2][2].getRed()) + 0.2;
			double g = (window[0][0].getGreen() + 2 * window[0][1].getGreen() + window[0][2].getGreen() - 
					     window[2][0].getGreen() - 2 * window[2][1].getGreen() - window[2][2].getGreen()) + 0.2;
			double b = (window[0][0].getBlue() + 2 * window[0][1].getBlue() + window[0][2].getBlue() - 
					     window[2][0].getBlue() - 2 * window[2][1].getBlue() - window[2][2].getBlue()) + 0.2;
			r = ((r < 0)? 0 : r);
			g = ((g < 0)? 0 : g);
			b = ((b < 0)? 0 : b);
			r = ((r > 1)? 1 : r);
			g = ((g > 1)? 1 : g);
			b = ((b > 1)? 1 : b);
			return new Color(r, g, b, 1);
		};
		ColorTransformer frame = (x, y, c) -> {
			if (x < 10 || x > in.getWidth() - 10 || y < 10 || y > in.getHeight() - 10)
				return Color.GRAY;
			else
				return c;
		};
		LatentImage out = LatentImage.from(in).transform(sobel).transform(Color::brighter).transform(frame);
		arg0.setScene(new Scene(new HBox(new ImageView(in), new ImageView(out.toImage()))));
		arg0.show();
	}
}
