package wendy.program;

public class EscapeRoom {
    String themename;
    String themecontent;
    String storename;

    public EscapeRoom(String themename, String themecontent, String storename) {
        this.themename = themename;
        this.themecontent = themecontent;
        this.storename = storename;
    }
    public String getThemename() {
        return themename;
    }

    public String getThemecontent() {
        return themecontent;
    }

    public String getStorename() {
        return storename;
    }

    public void setThemename(String themename) {
        this.themename = themename;
    }

    public void setThemecontent(String themecontent) {
        this.themecontent = themecontent;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }
}
