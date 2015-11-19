package ch09.ex02;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResourcePlus {
	public static void main(String[] args) {
		Scanner in = null;
		PrintWriter out = null;
		Throwable ex = null;
		try {
			in = new Scanner(Paths.get("./src/ch09/ex02/in.txt"));
			out = new PrintWriter("./src/ch09/ex02/out.txt");
			while (in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (Throwable e) {
			ex = e;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Throwable e) {
					ex.addSuppressed(e);
					System.out.println(ex);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Throwable e) {
					ex.addSuppressed(e);
					System.out.println(ex);
				}
			}
		}
	}
}
