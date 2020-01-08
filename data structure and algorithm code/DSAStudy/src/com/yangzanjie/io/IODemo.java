package com.yangzanjie.io;

import java.io.*;

/**
 * @author : yangzanjie
 * create at:  2019-12-13  12:52
 * @description:
 */
public class IODemo {
    public static void main(String[] args) {
        try {
//            OutputStream outputStream = new FileOutputStream(new File("/Users/yangzanjie/Desktop/test.txt"));
//            outputStream.write(234);
//            outputStream.flush();
//            outputStream.close();
//            Writer writer = new FileWriter(new File("/Users/yangzanjie/Desktop/test.txt"));
//            writer.write(12);
//            writer.flush();
//            writer.close();
            Reader reader  =  new FileReader(new File("/Users/yangzanjie/Desktop/test.txt"));

            System.out.println(reader.read());

            reader.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }
}
