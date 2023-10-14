package JDBCConnect.Config;

public enum EConfig {
    HOSTNAME("localhost"), PORT("3306"),DBNAME("projectv4"), INTEGRATED_SECURITY("false"),
    USERNAME("root"), PASSWORD("12345678");

    private final String DTB;


    private EConfig(String option) {
        this.DTB = option;
    }

    public String getDTB() {
        return this.DTB;
    }
}
