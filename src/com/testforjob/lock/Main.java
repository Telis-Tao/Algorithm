package com.testforjob.lock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by taoxiaoqing on 15/9/21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Proc> list = new ArrayList<Proc>();
        int count = 0;
        boolean isFirstLine = true;
        while (in.hasNext()) {
            String str = in.nextLine();
            if (isFirstLine) {
                count = Integer.valueOf(str);
                isFirstLine = false;
                continue;
            }
            count--;
            String[] strs = str.split(" ");
            String id = strs[0];
            String have = strs.length > 1 ? strs[1] : null;
            String wait = strs.length > 2 ? strs[2] : null;
            list.add(new Proc(id, have, wait));
            if (count <= 0) {
                break;
            }
        }
        int result = 0;
        int tmp = 0;
        for (Proc proc : list) {
            String[] have = proc.haves;
            for (String s : have) {
                for (Proc proc1 : list) {
                    if (proc1 != proc) {
                        for (String wait : proc1.wait) {
                            if (wait.equals(s)) {
                                tmp++;
                                break;
                            }
                        }
                        if (tmp != 0) {
                            result++;
                            tmp = 0;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    static class Proc {
        String id;
        String[] haves;
        String[] wait;

        public Proc(String id, String haves, String wait) {
            this.id = id;
            this.haves = haves == null ? new String[]{} : haves.contains(",") ? haves.split(",") : new String[]{haves};
            this.wait = wait == null ? new String[]{} : wait.contains(",") ? wait.split(",") : new String[]{wait};
        }

        @Override
        public String toString() {
            return "Proc{" +
                    "id='" + id + '\'' +
                    ", haves=" + Arrays.toString(haves) +
                    ", wait=" + Arrays.toString(wait) +
                    '}';
        }
    }
}
