package thread.死锁;

//互斥使用：一个资源只能分配给一个线程
//不可剥夺：资源只能由占有者释放，申请者不能强制剥夺
//请求保持：线程申请资源时，保持对原有资源的占有
//循环等待：存在一个进程等待队列：{P1 , P2 , … , Pn}, 其中P1等待P2占有的资源，P2等待P3占有的资源，…，Pn等待P1占有的资源，形成一个进程等待环路
//代码
//
//作者：被称为L的男人
//链接：https://www.jianshu.com/p/8cf78bf94f9d
//來源：简书
//简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。

public class DeadLock implements Runnable {
    // flag=1,占有对象o1，等待对象o2
    // flag=0,占有对象o2，等待对象o1

    public int flag = 1;

    // 定义两个Object对象，模拟两个线程占有的资源
    public static Object o1 = new Object();
    public static Object o2 = new Object();


    @Override
    public void run() {

        System.out.println("flag: " + flag);
        // deadLock2占用资源o1，准备获取资源o2
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        // deadLock1占用资源o2，准备获取资源o1
        else if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();

        deadLock1.flag = 0;
        deadLock2.flag = 1;

        Thread thread1= new Thread(deadLock1);
        Thread thread2 = new Thread(deadLock2);

        thread1.start();
        thread2.start();
    }
}
