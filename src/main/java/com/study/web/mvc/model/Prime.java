package com.study.web.mvc.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Prime {

    static Map<Integer,Boolean> results = new LinkedHashMap<>();
    
    public boolean getResult(int n){
        if(results.keySet().stream().anyMatch(key -> key == n )){
            return results.get(n);
        }
        results.put(n, isPrime(n));
        System.out.println(results.get(n));
        return results.get(n);
    }
    
    public void del(int n){
        results.remove(n);
    }
    
    public Map<Integer,Boolean> getResults(){
        return results;
    }
    
    // Java7 寫法
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime_java8(int n) {

        if (n <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, n ).anyMatch(i -> n % i == 0);
    }
}
