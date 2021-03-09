package com.felix.nowcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            String item = str;
            while (item.length() > 8) {
                System.out.println(item.substring(0, 8));
                item = item.substring(8);
            }
            System.out.print(item);
            for (int i = 0; i < 8 - item.length(); i++) {
                System.out.print("0");
            }
            System.out.println();
        }
    }
}