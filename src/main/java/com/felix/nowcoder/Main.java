package com.felix.nowcoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            boolean[] stu = new boolean[1001];
            for (int i = 0; i < n; i++) {
                stu[scanner.nextInt()] = true;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stu.length; i++) {
                if (stu[i]) {
                    sb.append(i).append("\n");
                }
            }
            System.out.println(sb);
        }
    }
}
