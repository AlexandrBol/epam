package ua.nure.bolshakov.practice1;

public class Part4 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else b %= a;
        }
        System.out.println(a + b);
    }
}

