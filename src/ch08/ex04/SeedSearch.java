package ch08.ex04;

public class SeedSearch {
	public static void main(String[] args) {
		//		0.33333334
		System.out.println((float) 1 / 3);
		//		0.3333333
		System.out.println(Math.nextDown((float) 1 / 3));
		//		0.29999999999999993
		System.out.println(Math.nextDown(0.3));
		//TODO あとで実施
	}
}
