package algorithm.thread.BuySubject;

public class C04 {
    class Account01 {  // 问题，粒度太粗，性能差;取款和修改密码是可以并行的，所以进行下一个的修改。
        // 锁：保护账号余额
        private final Object balLock = new Object();
        // 账户余额
        private Integer balance;
        // 锁：保护账号密码
        private final Object pwLock = new Object();
        // 账号密码
        private String password;

        // 取款
        void withdraw(Integer amt) {
            synchronized (balLock) {
                if (this.balance > amt)
                    this.balance -= amt;
            }
        }

        // 查看余额
        Integer getBalance() {
            synchronized (balLock) {
                return balance;
            }
        }

        // 更改密码
        void updatePassword(String pw) {
            synchronized (pwLock) {
                this.password = pw;
            }
        }

        // 查看密码
        String getPassword() {
            synchronized (pwLock) {
                return password;

            }
        }
    }


    class Account02 {  // 问题，粒度太粗，性能差  target.balance 不能被加锁
        private int balance;

        // 转账
        synchronized void transfer(Account02 target, int amt) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    class Account03 {
        private int balance;

        void transfer(Account03 target, int amt) {
            synchronized (Account03.class) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }

        }
    }
}
