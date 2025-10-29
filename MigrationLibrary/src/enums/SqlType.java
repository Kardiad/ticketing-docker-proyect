package enums;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum SqlType {

    // Numbers
    INT("Integer"),
    INTEGER("Integer"),
    SMALLINT("Short"),
    TINYINT("Byte"),
    BIGINT("Long"),
    DECIMAL("BigDecimal"),
    NUMERIC("BigDecimal"),
    FLOAT("Float"),
    REAL("Float"),
    DOUBLE("Double"),
    DOUBLE_PRECISION("Double"),
    MONEY("BigDecimal"),
    SMALLMONEY("BigDecimal"),
    SERIAL("Long"),
    BIGSERIAL("Long"),

    // Text
    CHAR("String"),
    NCHAR("String"),
    VARCHAR("String"),
    NVARCHAR("String"),
    TEXT("String"),
    NTEXT("String"),
    LONGTEXT("String"),
    MEDIUMTEXT("String"),
    CLOB("String"),
    ENUM("String"),
    SET("String"),

    // Dates and datestamps
    DATE("LocalDate"),
    TIME("LocalTime"),
    DATETIME("LocalDateTime"),
    TIMESTAMP("LocalDateTime"),
    TIMESTAMPTZ("OffsetDateTime"),
    SMALLDATETIME("LocalDateTime"),
    YEAR("Integer"),
    INTERVAL("Duration"),

    // Booleans
    BOOLEAN("Boolean"),
    BOOL("Boolean"),
    BIT("Boolean"),

    // Binaries
    BLOB("byte[]"),
    LONGBLOB("byte[]"),
    MEDIUMBLOB("byte[]"),
    TINYBLOB("byte[]"),
    BINARY("byte[]"),
    VARBINARY("byte[]"),
    BYTEA("byte[]"),

    // JSON / others
    JSON("String"),
    JSONB("String"),
    XML("String"),
    UUID("UUID"),
    GEOMETRY("Object"),
    POINT("Object"),
    ARRAY("List<Object>"),
    HSTORE("Map<String, String>");

    private final String javaType;

    SqlType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaType() {
        return javaType;
    }

    private static final Map<String, SqlType> LOOKUP = new HashMap<>();

    static {
        for (SqlType type : values()) {
            LOOKUP.put(type.name(), type);
        }
    }

    /**
     * Returns jpa param type to sql variable.
     * Ignores cases
     */
    public static String fromSqlType(String sqlType) {
        if (sqlType == null) return "Object";
        String clean = sqlType.trim().toUpperCase()
                .replaceAll("\\(.*\\)", "");
        SqlType type = LOOKUP.get(clean);
        return (type != null) ? type.getJavaType() : "Object";
    }

}