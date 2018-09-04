package ua.nure.bolshakov.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	public static void main(String[] args) {
		String file = Util.readFile("practice4.part3");
		whatDataType(file);
	}

	static void whatDataType(String data) {
		Scanner in = new Scanner(System.in);
		System.out.println("Choose data type. If you want to break write \"stop\"");
		String s = "";
		while (!s.equals("stop")) {
			switch (in.nextLine()) {
				case "int":
					System.out.println(isInteger(data));
					break;
				case "double":
					System.out.println(isDouble(data));
					break;
				case "string":
					System.out.println(isString(data));
					break;
				case "char":
					System.out.println(isChar(data));
					break;
				case "stop":
					s = "stop";
					break;
			}
		}
		in.close();
	}

	static String isInteger(String file) {
		return Checker(file,"\\s\\d{1,}\\s");
	}

	static String isDouble(String file) {
		return Checker(file,"\\d*[.]\\d*\\w");
	}

	static String isString(String file) {
		return Checker(file,"\\p{L}{2,}");
	}

	static String isChar(String file) {
		return Checker(file,"\\s\\p{L}");
	}

	private static String Checker(String file, String regular) {
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile(regular);
		Matcher m = pattern.matcher(file);
		while (m.find()) {
			sb.append(m.group() + " ");
		}
		return sb.toString();
	}
}