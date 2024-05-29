package wendy.program;

public class ThreadData {
    Bank account;
    int playPrice;

    public ThreadData(Bank account, int playPrice) {
        this.account = account;
        this.playPrice = playPrice;
    }

    public int getPlayPrice() {
        return playPrice;
    }

    public Bank getAccount() {
        return account;
    }

    public void setAccount(Bank account) {
        this.account = account;
    }

    public void setPlayPrice(int playPrice) {
        this.playPrice = playPrice;
    }
}




