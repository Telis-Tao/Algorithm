package com.testforjob.linux_version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Version> list = new ArrayList<Version>();
        String str;
        boolean isFirstLine = true;
        int count = 0;
        while (in.hasNextLine()) {
            String[] strs;
            str = in.nextLine();
            if (isFirstLine) {
                isFirstLine = false;
                count = Integer.valueOf(str);
                continue;
            }
            if (str.trim().equals("")) {
                break;
            }
            count--;
            if (str.contains(".")) {
                strs = str.split("\\.");
            } else {
                strs = new String[]{str};
            }
            long first = Long.valueOf(strs[0]);
            long second = strs.length > 1 ? Long.valueOf(strs[1]) : 0;
            if (second % 2 != 0) {
                continue;
            }
            long third = strs.length > 2 ? Long.valueOf(strs[2]) : 0;
            list.add(new Version(first, second, third, str.trim()));
            if (count <= 0) {
                break;
            }
        }
        if (list.isEmpty()) {
            System.out.println("no stable available");
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    static class Version implements Comparable<Version> {
        public long first;
        public long second;
        public long third;
        public String data;

        public Version(long first, long second, long third, String data) {
            this.first = first;
            this.second = second;
            this.third = third;
            this.data = data;
        }

        @Override
        public int compareTo(Version o) {
            long result = o.first - this.first;
            if (result != 0) {
                return (int) result;
            }
            result = o.second - this.second;
            if (result != 0) {
                return (int) result;
            }
            return (int) (o.third - this.third);
        }

        @Override
        public String toString() {
            return data;
        }
    }
}
