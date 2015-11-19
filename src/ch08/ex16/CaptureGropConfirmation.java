package ch08.ex16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaptureGropConfirmation {
	public static void main(String[] args) {
		String address1 = "Tokyo,shinagawa,12345";
		String address2 = "Tokyo,ohmori,123456789";

		parseAddress(address1);
		parseAddress(address2);
	}

	public static void parseAddress(String address) {
		Pattern pattern = Pattern.compile("(?<city>[\\p{L}]+),(?<state>[\\p{L}]+),(?<zipcode>[0-9]{5}|[0-9]{9})");
		Matcher matcher = pattern.matcher(address);
		if (matcher.matches()) {
			System.out.println("city: " + matcher.group("city") + "\nstate: " + matcher.group("state") + "\nzipcode:"
					+ matcher.group("zipcode"));
		}
		else {
			System.out.println("error");
		}
	}
}
