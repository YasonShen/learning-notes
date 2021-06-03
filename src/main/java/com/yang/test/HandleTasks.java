package com.yang.test;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandleTasks {


    static class StartAgent implements Runnable{

        private CountDownLatch countDownLatch;

        @Override
        public void run() {
            try{
                System.out.println("开始启动节点：" + Thread.currentThread().getName());
                //模拟每个任务执行3秒钟
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //线程池10个线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //第一批十个任务
        List<StartAgent> agentsStart = Lists.newArrayList(new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent());
        //第二批十个任务
        List<StartAgent> agentsStart2 = Lists.newArrayList(new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent(),new StartAgent());
        List<List<StartAgent>> task = new ArrayList<>();
        task.add(agentsStart);
        task.add(agentsStart2);
        //记录任务执行时间
        long t1 = System.currentTimeMillis();
        CountDownLatch c ;
        //循环任务组
        for(List<StartAgent> startList : task){
            //定义线程阻塞为10
            c = new CountDownLatch(10);
            for(StartAgent agent : startList){
                agent.setCountDownLatch(c);
                executorService.submit(agent);
            }
            //阻塞，等待十个任务都执行后，才继续下一批10任务
            c.await();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("执行时间："+  (t2 - t1)/1000);
        executorService.shutdown();
    }
}
