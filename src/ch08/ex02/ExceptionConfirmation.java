package ch08.ex02;

public class ExceptionConfirmation {
	public static void main(String[] args) {
		try {
			Math.negateExact(Integer.MIN_VALUE);
		} catch (ArithmeticException e) {
			System.out.println("error");
		}
	}
}
