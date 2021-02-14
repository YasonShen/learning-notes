package com.yang.test;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

public class ContainerNotSafeDemo {

    public static void main(String[] args) {

//        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,6,200,TimeUnit.SECONDS(3), );


    }

    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         * 1。故障现象
         *      java.util.ConcurrentModificationException
         *
         * 2.导致原因
         *      并发争抢修改导致
         *      一个人再写入，另外一个过来抢夺，导致数据不一致异常，并发修改异常
         *
         * 3。解决方案
         *      3.1 new Vector<>()
         *      3.2 Collections.synchronizedList(new ArrayList<>())
         *      3.3 new CopyOnWriteArrayList<>()
         *
         * 最后我们再来看一下CopyOnWriteArrayList的优点和缺点:
         *      优点:解决的开发工作中的多线程的并发问题。
         *
         * 缺点:
         *      1.内存占有问题:很明显，两个数组同时驻扎在内存中，如果实际应用中，数据比较多，而且比较大的情况下，占用内存会比较大，针对这个其实可以用ConcurrentHashMap来代替。
         *      2.数据一致性:CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。所以如果你希望写入的的数据，马上能读到，请不要使用CopyOnWrite容器
         */
     }
}
