package wendy.program;

public class Bank {
    int money;
    public Bank(int initialmoney) {
        this.money = initialmoney;
    }

    public synchronized void withdraw(int persons, int playPrice) {
        if (money >= playPrice*persons) {
            for(int i=0; i<persons; i++) {
                money -= playPrice;
                System.out.println("1명 결제가 완료되었습니다. 잔액: " + money);
            }
            System.out.println("");
        } else {
            System.out.println(persons+"명의 금액을 결제할 잔액이 부족합니다. 결제를 진행할 수 없습니다.");
        }
    }
}