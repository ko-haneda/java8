package ch09.ex08;

public class Point implements Comparable<Point> {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point other) {
		int diff = (x < other.x) ? -1 : ((x == other.x) ? 0 : 1);
		if (diff != 0)
			return diff;
		return (y < other.y) ? -1 : ((y == other.y) ? 0 : 1);
	}

	public static void main(String[] args) {
		Point p1 = new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);
		Point p2 = new Point(Integer.MAX_VALUE, Integer.MIN_VALUE);

		System.out.println(p1.compareTo(p2));
		System.out.println(p2.compareTo(p1));

	}
}