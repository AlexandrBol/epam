package ua.nure.bolshakov.practice1;

public class Part5 {
    public static void main(String[] args) {

        int d = Integer.parseInt(args[0]);
        int sum = 0;

        while (d > 0) {
            sum += d % 10;
            d /= 10;
        }

        System.out.print(sum);
    }
}
