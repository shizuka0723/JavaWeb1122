package com.study.web.mytag;

import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        long[] abc = Stream.iterate(new long[]{1,1}, l->new long[]{l[1],l[0]+l[1]}).limit(31).reduce((a,b)->b).get();
        for(long x : abc){
            System.out.println(x);
        }
       
    }
}
