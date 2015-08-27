package ch03.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import ch03.ex12.TranceformerImage.ColorTransformer;

public class LatentImage {
	private Image in;
	private List<ColorTransformer> pendingOperations = new ArrayList<>();

	private LatentImage(Image in) {
		this.in = in;
	}

	public LatentImage transform(UnaryOperator<Color> f) {
		pendingOperations.add((x, y, color) -> f.apply(color));
		return this;
	}

	public LatentImage transform(ColorTransformer f) {
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
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for (ColorTransformer f : pendingOperations) c = f.apply(x, y, c);
				out.getPixelWriter().setColor(x, y, c);
			}
		return out;
	}
	
}
