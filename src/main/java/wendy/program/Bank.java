package wendy.program;

public class Bank {
    int money;
    private boolean paymentProgress;

    public Bank(int initialmoney) {
        this.money = initialmoney;
        this.paymentProgress = false;
    }

    public synchronized void startPayment() {
        this.paymentProgress = true;
    }

    public synchronized void endPayment() {
        this.paymentProgress = false;

    }

    public synchronized void withdraw(int playPrice) throws InterruptedException {
        startPayment();
        Thread.sleep(500);
        money -= playPrice;
        System.out.println("1명 결제가 완료되었습니다. 잔액: " + money);
        endPayment();
    }
}