package wendy.program;

public class PaymentThread implements Runnable {
    private Bank account;
    private int persons;
    private int playPrice;

    public PaymentThread(Bank account, int persons, int playPrice) {
        this.account = account;
        this.persons = persons;
        this.playPrice = playPrice;
    }

    @Override
    public void run() {
        account.withdraw(persons,playPrice);
    }
}
