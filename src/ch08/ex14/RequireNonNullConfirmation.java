package ch08.ex14;

import java.util.Objects;

public class RequireNonNullConfirmation {

	//TODO
	public static void main(String[] args) {
		try {
			//Aという用語を教科書で探す。みつからなければ(nullであれば)辞書で探す。
			String str = Objects.requireNonNull("", () -> "");
			System.out.println(str);
		} catch (NullPointerException e) {
			System.out.println("NPE: " + e.getMessage());
		}
	}

}
