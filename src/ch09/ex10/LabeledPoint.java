package ch09.ex10;

import java.util.Objects;

public class LabeledPoint implements Comparable<LabeledPoint> {
	private final String label;
	private final int x;
	private final int y;

	public LabeledPoint(int x, int y, String label) {
		this.x = x;
		this.y = y;
		this.label = label;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		return (hashCode() == ((LabeledPoint) obj).hashCode());
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + this.x;
		result = 31 * result + this.y;
		result = 31 * result + Objects.hashCode(this.label); //TOO
		return result;
	}

	@Override
	public int compareTo(LabeledPoint other) {
		int diff = (x < other.x) ? -1 : ((x == other.x) ? 0 : 1);
		if (diff != 0)
			return diff;
		diff = (y < other.y) ? -1 : ((y == other.y) ? 0 : 1);
		if (diff != 0)
			return diff;
		return label.compareTo(other.label);
	}

	//equalsがtrueを返すとき、compareが０になることを確認
	public static void main(String[] args) {
		LabeledPoint p1 = new LabeledPoint(1, 2, "a");
		LabeledPoint p2 = new LabeledPoint(1, 2, "a");
		LabeledPoint p3 = new LabeledPoint(2, 1, "a");
		LabeledPoint p4 = new LabeledPoint(1, 2, "aaa");

		System.out.println("p1 hash = " + p1.hashCode());

		System.out.println(p1.equals(p2));
		System.out.println(p1.compareTo(p2));
		System.out.println("p2 hash = " + p2.hashCode());

		System.out.println(p1.equals(p3));
		System.out.println(p1.compareTo(p3));
		System.out.println("p3 hash = " + p3.hashCode());

		System.out.println(p1.equals(p4));
		System.out.println(p1.compareTo(p4));
		System.out.println("p4 hash = " + p4.hashCode());
	}

}
