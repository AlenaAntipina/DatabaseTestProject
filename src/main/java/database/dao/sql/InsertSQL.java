package database.dao.sql;

public enum InsertSQL {
    INSERT_INTO_AUTHOR("INSERT INTO author (name, login, email) VALUES (?,?,?)"),
    INSERT_INTO_PROJECT("INSERT INTO project (name) VALUE (?)"),
    INSERT_INTO_SESSION("INSERT INTO session (session_key, created_time, build_number) VALUES (?,?,?)"),
    INSERT_INTO_TEST("INSERT INTO test (name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser) VALUES (?,?,?,?,?,?,?,?,?)");

    private String sql;
    private InsertSQL(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
