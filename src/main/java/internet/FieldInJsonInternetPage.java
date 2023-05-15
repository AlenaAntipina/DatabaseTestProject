package internet;

public enum FieldInJsonInternetPage {
    MAIN_URL("mainUrl");

    private String url;
    private FieldInJsonInternetPage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
