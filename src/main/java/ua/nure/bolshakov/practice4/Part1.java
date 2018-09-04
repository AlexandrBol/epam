package ua.nure.bolshakov.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        String file = Util.readFile("practice4part1");
        System.out.println(toUpperCase(file));
    }

    public static String toUpperCase(String text) {
        Pattern p = Pattern.compile("\\p{L}{4,}", Pattern.MULTILINE);
        Matcher m = p.matcher(text);
        while (m.find()) {
            text = text.replace(m.group(), m.group().toUpperCase());
        }
        return text;
    }

}
