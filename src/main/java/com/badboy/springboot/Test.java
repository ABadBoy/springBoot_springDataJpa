package com.badboy.springboot;


public class Test {


    private static boolean ready;
    private static int number;


    private static class ReaderThread extends Thread {

        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(ready);
                System.out.println(number);
            }
        }
    }



    public static void main(String[] args) {
        //new ReaderThread().run();
        number = 42;
        ready = true;
        System.out.println(test("zbcdefg"));
    }


    public static String test(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2, n);
        return test(a)+test(b);
    }
}
