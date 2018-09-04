package ua.nure.bolshakov.practice4;

import java.io.FileNotFoundException;

import java.util.Random;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {
        Util.createFile(genrateNumbers(10, 50), "practice4part2");
        String file = Util.readFile("practice4part2");
        System.out.println(file);

        Util.createFile(ArrToString(sort(StringtoArr(file))), "practice4part2_sorted");

        System.out.println(Util.readFile("practice4part2_sorted"));
    }

    static String genrateNumbers(int intCount, int range) {
        Random rnd = new Random();
        int[] numbs = new int[intCount];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = rnd.nextInt(range);
            sb.append(numbs[i]).append(" ");
        }
        return sb.toString();
    }

    static int[] StringtoArr(String s) {
        String[] stringData = s.split(" ");
        int[] data = new int[stringData.length];
        for (int i = 0; i < stringData.length; i++) {
            data[i] = Integer.parseInt(stringData[i]);
        }
        return data;
    }

    static String ArrToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    static int[] sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
