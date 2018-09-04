package ua.nure.bolshakov.practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Util {

    private static final String ENCODING = "UTF-8";

    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    static void createFile(String s, String fileName) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(fileName));
        printWriter.write(s);
        printWriter.close();
    }

//    static void writeToFile(String s, String fileName) throws FileNotFoundException {
//        PrintWriter printWriter = new PrintWriter(fileName);
//        printWriter.write(s);
//        printWriter.close();
//    }


    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }

}
