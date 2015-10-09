package com.testforjob;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by taoxiaoqing on 15/9/20.
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(solution());
//        B b = new B();
//        WeakHashMap wMap = new WeakHashMap();
//        wMap.put("张三", "zs");
//        wMap.put("李四", "ls");
//        //gc,不保证运行
//        try {
//            System.gc();
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        for (Object o : wMap.entrySet()) {
//            System.out.println(o);
//        }
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(i+1);
        }
//        for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
//            for (Iterator<Integer> j = list.iterator(); j.hasNext(); ) {
//                System.out.println(i.next()+"-"+j.next());
//            }
//        }
        for (Integer integer : list) {
            if(integer.equals(3)){
                list.remove(integer);
            }
        }
        System.out.println(list);
    }

    public static String solution() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        double num = Integer.valueOf(inputs[0]);
        int count = Integer.valueOf(inputs[1]);
        double sum = num;
        while (--count > 0) {
            num = Math.pow(num, 0.5);
            sum += num;
        }
        return String.format("%.2f", sum);
    }
    static class A {
        public A() {
            System.out.println("A");
        }
    }
    static class B{
        A a = new A();

        public B() {
            System.out.println("B");
        }
    }
}
