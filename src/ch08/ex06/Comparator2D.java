package ch08.ex06;

import java.util.Comparator;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Comparator2D {
	public static Comparator<Point2D> compPoint() {
		return Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY);
	}

	public static Comparator<Rectangle2D> compRrectangle() {
		return Comparator.comparing(Rectangle2D::getMaxX).thenComparing(Rectangle2D::getMinX)
				.thenComparing(Rectangle2D::getMaxY).thenComparing(Rectangle2D::getMinY);
	}

	public static void main(String[] args) {
		Point2D p1 = new Point2D(1, 2);
		Point2D p2 = new Point2D(-1, 3);
		System.out.println(p1 + "\n" + p1 + "\n" + compPoint().compare(p1, p1) + "\n");
		System.out.println(p1 + "\n" + p2 + "\n" + compPoint().compare(p1, p2) + "\n");
		System.out.println(p2 + "\n" + p1 + "\n" + compPoint().compare(p2, p1) + "\n");
		Rectangle2D r1 = new Rectangle2D(1, 3, 1, 2);
		Rectangle2D r2 = new Rectangle2D(1, 2, 2, 3);
		System.out.println(r1 + "\n" + r1 + "\n" + compRrectangle().compare(r1, r1) + "\n");
		System.out.println(r1 + "\n" + r2 + "\n" + compRrectangle().compare(r1, r2) + "\n");
		System.out.println(r2 + "\n" + r1 + "\n" + compRrectangle().compare(r2, r1) + "\n");
	}
}