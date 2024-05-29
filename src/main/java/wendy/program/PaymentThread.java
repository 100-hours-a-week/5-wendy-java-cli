package wendy.program;

public class PaymentThread implements Runnable {
    private RecommendationUtils recommendationUtils;

    public PaymentThread(RecommendationUtils recommendationUtils) {
        this.recommendationUtils = recommendationUtils;
    }

    @Override
    public void run() {
        while (true) {
            ThreadData data = this.recommendationUtils.getData();
            if (data != null) {
                Bank account = data.getAccount();
                int playPrice = data.getPlayPrice();
                try {
                    System.out.println("결제 하는 중...");
                    account.withdraw(playPrice);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.recommendationUtils.clearData();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (this.recommendationUtils.getFinish()) {
                break;
            }
        }
    }
}