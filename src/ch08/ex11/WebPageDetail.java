package ch08.ex11;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

//取得できなくなった...
public class WebPageDetail {
	private static final String TARGET = "https://github.com/login";

	public static void main(String[] args) throws IOException {
		String user = "ko-haneda";
		String password = "white1116"; //削除
		URLConnection connection = new URL(TARGET).openConnection();
		Base64.Encoder encoder = Base64.getEncoder();
		String user_pass = user + ":" + password;
		String encoded = encoder.encodeToString(user_pass.getBytes(StandardCharsets.UTF_8));
		connection.setRequestProperty("Authorization", "Basic " + encoded);
		connection.connect();
		try (Scanner input = new Scanner(connection.getInputStream(), "Shift_JIS")) {
			while (input.hasNextLine()) {
				System.out.println(input.nextLine());
			}
		}
	}

}
