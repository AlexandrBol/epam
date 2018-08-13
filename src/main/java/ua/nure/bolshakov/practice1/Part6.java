package ua.nure.bolshakov.practice1;

import java.util.Arrays;

public class Part6 {
    public static void main(String[] args) {

        int[] arr = new int[Integer.parseInt(args[0])];

        int i = 0;

        for (int j = 2; j < 1000; j++) {

            if (Part6.isSimple(j)) {
                arr[i] = j;
                i++;
            }
            if (i == arr.length) break;
        }
        System.out.println(Arrays.toString(arr));
    }


    public static boolean isSimple(int x) {
        boolean isComposite = false;

        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                isComposite = true;
                break;
            }
        }
        if (!isComposite) {
            return true;
        } else {
            return true;
        }
    }

}
