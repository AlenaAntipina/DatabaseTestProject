package database.dao.sql;

public enum SelectSQL {
    SELECT_ALL_FROM_AUTHOR("SELECT * FROM author"),
    SELECT_ALL_FROM_AUTHOR_BY_ID("SELECT * FROM author WHERE id =?"),

    SELECT_ALL_FROM_PROJECT("SELECT * FROM project"),
    SELECT_ALL_FROM_PROJECT_BY_ID("SELECT * FROM project WHERE id =?"),

    SELECT_ALL_FROM_SESSION("SELECT * FROM session"),
    SELECT_ALL_FROM_SESSION_BY_ID("SELECT * FROM session WHERE id =?"),

    SELECT_ALL_FROM_TEST("SELECT * FROM test"),
    SELECT_ALL_FROM_TEST_BY_ID("SELECT * FROM test WHERE id =?");

    private String sql;
    private SelectSQL(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
