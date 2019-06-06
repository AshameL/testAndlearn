package algorithm.thread.ThreadLocal;

public class Example2 {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    ThreadLocal<String > stringThreadLocal = new ThreadLocal<>();

    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public long getLong(){
        return longThreadLocal.get();
    }

    public String getString(){
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Example2 example2 = new Example2();

        example2.set();
        System.out.println(example2.getLong());
        System.out.println(example2.getString());

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                example2.set();;
                System.out.println(example2.getLong());
                System.out.println(example2.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(example2.getLong());
        System.out.println(example2.getString());
    }


}
