package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // System.in ==> 표준 입력
        // 테스트봇 만들기
        Scanner scan = new Scanner("aaa\nbbb\n");
        String input = scan.nextLine();
        System.out.println(input);
    }
}