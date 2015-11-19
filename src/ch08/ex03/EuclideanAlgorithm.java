package ch08.ex03;

public class EuclideanAlgorithm {
	public static void main(String[] args) {

		//答えは４
		System.out.println(percent(8, 28));
		System.out.println(floorMod(8, 28));
		System.out.println(rem(8, 28));

		System.out.println(percent(-8, 28));
		System.out.println(floorMod(-8, 28));
		System.out.println(rem(-8, 28));

		System.out.println(percent(8, -28));
		System.out.println(floorMod(8, -28));
		System.out.println(rem(8, -28));

		System.out.println(percent(-8, -28));
		System.out.println(floorMod(-8, -28));
		System.out.println(rem(-8, -28));
		//remが一番かんたん
	}

	public static int percent(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if (b == 0) {
			return a;
		}
		return a % b == 0 ? b : percent(b, a % b);
	}

	public static int floorMod(int a, int b) {
		//aもbもマイナスの場合、計算が煩わしいので結局最初に絶対値にした方がよい。
		a = Math.abs(a);
		b = Math.abs(b);
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if (b == 0) {
			return a;
		}
		return Math.floorMod(a, b) == 0 ? b : floorMod(b, Math.floorMod(a, b));
	}

	public static int rem(int a, int b) {
		if (b == 0) {
			return a;
		}
		return Integer.remainderUnsigned(a, b) == 0 ? b : rem(b, Integer.remainderUnsigned(a, b));
	}
}
