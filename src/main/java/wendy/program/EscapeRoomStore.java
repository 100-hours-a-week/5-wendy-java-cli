package wendy.program;

public class EscapeRoomStore {
    String region;
    String storename;

    public EscapeRoomStore(String region, String storename) {
        this.region = region;
        this.storename = storename;
    }
    public String getRegion() {
        return region;
    }

    public String getStorename() {
        return storename;
    }
}
