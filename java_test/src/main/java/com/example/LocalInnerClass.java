package com.example;

/**
 * Created by jinyTable on 2017/9/12.
 */

public class LocalInnerClass {
    private int count = 0;
    Counter getCounter (final String name ) {
        class LocalCounter implements Counter {
            public LocalCounter(){
                System.out.println("LocalCounter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }
    Counter getCounterNe(final String name ){
        return new Counter() {
            {
                System.out.println("getCounter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter c1 = lic.getCounter("local"),
                c2 = lic.getCounterNe("anonymous inner");
        for(int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }
        for(int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}
