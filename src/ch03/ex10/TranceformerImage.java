package ch03.ex10;

/**
 * 
 * 問１
 * 下記の呼び出しができないのはなぜか。
 * UnaryOperator<Color> op = Color::brighter;
 * Image finalImage = transform(image, op.compose(Color::grayscale));
 *
 *　→composeメソッドの返り値がFunction<V,R>であるため。
 *　
 * 問２
 * ストラクチャル型とノミナル型のユーティリティに関して、何がいえるか。
 * →
 */

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

	public static <T> Image transform(Image in, UnaryOperator<Color> c) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, c.apply(in.getPixelReader().getColor(x, y)));
			}
		}
		return out;
	}

	//型 TranceformerImage のメソッド transform(Image, UnaryOperator<Color>) は引数 (Image, Function<Color,Color>) に適用できません
	public void start(Stage arg0) throws Exception {
		Image in = new Image("file:./src/ch03/ex10/sample.png");
		UnaryOperator<Color> op = Color::brighter;
//		Image out = transform(in, op.compose(Color::grayscale));
		Image out = transform(in,  (UnaryOperator<Color>)op.compose(Color::grayscale));

		arg0.setScene(new Scene(new HBox(new ImageView(in), new ImageView(out))));
		arg0.show();
	}
}
