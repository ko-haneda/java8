package ch08.ex01;

public class Calculation {
	public int value;

	public Calculation(int value) {
		this.value = value;
	}

	public long add(int value) {
		return Integer.toUnsignedLong(this.value) + Integer.toUnsignedLong(value);
	}

	public long sub(int value) {
		return Integer.toUnsignedLong(this.value) - Integer.toUnsignedLong(value);
	}

	public int div(int value) {
		return (int) (Integer.toUnsignedLong(this.value) / Integer.toUnsignedLong(value));
		//        return Integer.divideUnsigned(this.value, value);
	}

	public int compare(int value) {
		return Long.compare(Integer.toUnsignedLong(this.value), Integer.toUnsignedLong(value));
	}

	public static void main(String[] args) {
		//divideUnsignedもremainderUnsignedも必要にならない？

		System.out.println(Integer.MAX_VALUE);

		long bigValue = (long) (Math.pow(2, 32) - 1);
		Calculation c = new Calculation(100000);

		System.out.println(c.add((int) bigValue));

		System.out.println(c.sub((int) bigValue));

		c.value = (int) bigValue;
		System.out.println(c.div(100));

		System.out.println(c.compare(100));
	}
}
