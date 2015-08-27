package ch03.ex13;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;
import ch03.ex13.TranceformerImage.ColorTransformer;

@FunctionalInterface
public interface PixelWindow {
	
	Color apply(int x, int y, Color[][] matrix);

	public static PixelWindow toPixelWindow(UnaryOperator<Color> f) {
		return (x, y, matrix) -> f.apply(matrix[1][1]);
	}

	public static PixelWindow toPixelWindow(ColorTransformer f) {
		return (x, y, matrix) -> f.apply(x, y, matrix[1][1]);
	}
}
