package database;

public enum FieldInJsonJDBC {
    USER_NAME("userName"),
    PASSWORD("password"),
    URL("url");

    private String url;
    private FieldInJsonJDBC(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
