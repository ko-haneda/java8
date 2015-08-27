package ch03.ex13;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ch03.ex13.TranceformerImage.ColorTransformer;

public class LatentImage {
	private Image in;
	private List<PixelWindow> pendingOperations = new ArrayList<>();

	private LatentImage(Image in) {
		this.in = in;
	}

	public LatentImage transform(UnaryOperator<Color> f) {
		pendingOperations.add(PixelWindow.toPixelWindow(f));
		return this;
	}

	public LatentImage transform(ColorTransformer f) {
		pendingOperations.add(PixelWindow.toPixelWindow(f));
		return this;
	}

	public LatentImage transform(PixelWindow f) {
		pendingOperations.add(f);
		return this;
	}

	//ファクトリメソッド
	public static LatentImage from(Image in) {
		return new LatentImage(in);
	}

	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width, height);
		//あらかじめ初期化
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, in.getPixelReader().getColor(x, y));
			}
		}
		Image buf = in;
		Color[][] window = new Color[3][3]; 
		for (PixelWindow f : pendingOperations) {
			for (int x = 1; x < width - 1; x++) {
				for (int y = 1; y < height - 1; y++) {
					window[0][0] = buf.getPixelReader().getColor(x - 1, y - 1);
					window[0][1] = buf.getPixelReader().getColor(x    , y - 1);
					window[0][2] = buf.getPixelReader().getColor(x + 1, y - 1);
					window[1][0] = buf.getPixelReader().getColor(x - 1, y);
					window[1][1] = buf.getPixelReader().getColor(x    , y);
					window[1][2] = buf.getPixelReader().getColor(x + 1, y);
					window[2][0] = buf.getPixelReader().getColor(x - 1, y + 1);
					window[2][1] = buf.getPixelReader().getColor(x    , y + 1);
					window[2][2] = buf.getPixelReader().getColor(x + 1, y + 1);
					out.getPixelWriter().setColor(x, y, f.apply(x, y, window));
				}
			}
			buf = out;
		}
		return out;
	}

}
