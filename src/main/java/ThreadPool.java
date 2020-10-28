import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ThreadPool {


    /**
      出现 new Thread(Runnable).start();
      可以考虑用Executor 代替
      优势：1）可以复用现有的线程类似数据的连接池，避免任务过多创建销毁线程的巨大开销
            2）任务到达时，工作线程已经存在，节约创建线程的时间，任务更快执行
     */

    public static void main(String[] args) {
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
    }





    /**
     * 线程池也可以处理带返回值的异步任务
     */
    private static void method5() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Future<String> future = service.submit(() -> {
                String threadName = Thread.currentThread().getName();
                try {
                    Thread.sleep(3000);
                    if("pool-1-thread-1".equals(threadName)){
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return threadName;
            });
            list.add(future);
        }
        System.out.println("任务提交完成....");
        list.forEach(n->{
            try {
                System.out.println(n.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
    }

    /**
     * newFixedThreadPool 可以在线程意外终止之后重新开启新的线程
     */
    private static void method4() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i <10 ; i++) {
            service.execute(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName);
                int number = Integer.parseInt(threadName.substring(threadName.length() - 1, threadName.length()));
                int b=1/(number%3);

            });
        }

        try {
            Thread.sleep(3000);
            System.out.println("sleep 3s...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <20 ; i++) {
            service.execute(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName);

            });
        }

        service.shutdown();
    }

    /**
     * 线程池初始化时 并未初始化核心线程,而是执行一个任务时，初始化一个线程,
     * 而且没新增一个任务 就算之前的任务执行完毕，线程执行完毕，只要已启动的核心线程小于设置的核心线程数，则会继续创建新的线程，而不是用以前的
     */
    private static void method3() {
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20000; i++) {
            service.execute(()-> {
                    System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println("end>>>>>>>>>>>>>>>>>>>>");
        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms--------------------");
        service.shutdown();
        end = System.currentTimeMillis();
        System.out.println(end-start+"ms--------------------");
    }

    /**
     * 线程池初始化时 并未初始化核心线程
     */
    private static void method2() {
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(Integer.MAX_VALUE);
        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms--------------------");
    }

    /**
     * 线程不能无线创建
     */
    public static void method1(){
        for (int i = 0; i < 9999; i++) {
            new Thread(()-> {System.out.println(Thread.currentThread().getName());
                while (true){

                }

            }).start();
        }

    }

}
