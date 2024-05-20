package wendy.program;

public class EscapeRoom {
    String region;
    String storename;

    public EscapeRoom(String region, String storename) {
        this.region = region;
        this.storename = storename;
    }
    public String getRegion() {
        return region;
    }

    public String getStorename() {
        return storename;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }
}
