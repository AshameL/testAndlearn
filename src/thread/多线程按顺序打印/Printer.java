package thread.多线程按顺序打印;

public class Printer {
    private static final int END_NUM = 10;
    static int orderNum = 0;

    //锁
    static Object object = new Object();

    static class ThreadPrinter extends Thread {
        private int printNum;

        public ThreadPrinter(int printNum) {
            this.printNum = printNum; //获取自己需要打印的数字
        }

        @Override
        public void run() {
            synchronized (object) { //判断该资源是否正在被占用
                while (orderNum < END_NUM) {  //如果资源空闲则锁定资源判断是否已经打印完成
                    if (orderNum == printNum) {  //没有打印完成则判断是否是自己需要打印的数字
                        System.out.println(printNum);
                        orderNum++;
                        if (orderNum == 10) {
                            System.out.println("打印完毕");
                        }
                        object.notifyAll();//打印完成后唤醒所有等待的线程
                    } else {
                        try {
                            object.wait();//不是自己打印的数字则该线程被阻塞，继续等待
                        } catch (InterruptedException e) {
                            System.out.println("线程" + printNum + "被打断了");
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPrinter[] threadPrinters = new ThreadPrinter[10];
        //初始化多线程启动
        for (int i = END_NUM - 1; i >= 0; i--) {
            threadPrinters[i] = new ThreadPrinter(i);
            threadPrinters[i].start();
        }
    }
}
