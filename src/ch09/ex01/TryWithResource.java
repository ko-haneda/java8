package ch09.ex01;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResource {
	public static void main(String[] args) {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get("./src/ch09/ex01/in.txt"));
			out = new PrintWriter("./src/ch09/ex01/out.txt");
			while (in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (Throwable e) {
			System.out.println(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable e) {
					System.out.println(e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Throwable e) {
					System.out.println(e);
				}
			}
		}
	}
}
