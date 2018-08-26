package ua.nure.bolshakov.practice1;

public class Part7 {
    private static final int BASE_26 = 26;

    public static void main(String[] args) {
        output("A");
        output("B");
        output("Z");
        output("AA");
        output("AZ");
        output("BA");
        output("ZZ");
        output("AAA");
    }

    public static void output(String number) {
        int digits = charsToDigits(number);
        System.out.println(number + " ==> " + digits + " ==> " + digitsToChars(digits));
    }

    public static int charsToDigits(String number) {
        int result = charToInt(number.charAt(number.length() - 1));
        int counter = 1;
        for (int i = number.length() - 2; i >= 0; i--) {
            result += Math.pow(BASE_26, counter) * charToInt(number.charAt(i));
            counter++;
        }
        return result;
    }

    public static int charToInt(char character) {
        return character - 'A' + 1;
    }

    public static String digitsToChars(int number) {
        StringBuilder result = new StringBuilder();
        int digits = number;
        int mod;
        while (digits != 0) {
            digits--;
            mod = digits % BASE_26;
            result.insert(0, intToChar(mod));
            digits /= BASE_26;
        }
        return result.toString();
    }

    public static char intToChar(int digit) {
        return (char) ('A' + digit);
    }

}
