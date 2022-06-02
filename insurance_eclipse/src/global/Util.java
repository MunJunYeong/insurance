package global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Util {
	public static int IntReader(String data) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(data);
		try {
			return Integer.parseInt(br.readLine().trim());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static String StringReader(String data) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(data + " ");
		try {
			return br.readLine().trim();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			return "error";
		}
	}

}
