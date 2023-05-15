package database.table.tablefields;

public enum AuthorField {
    ID("id"),
    NAME("name"),
    LOGIN("login"),
    EMAIL("email");

    private String field;

    private AuthorField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
