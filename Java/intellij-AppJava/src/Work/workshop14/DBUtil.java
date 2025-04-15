package Work.workshop14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {
    private static final Properties props = new Properties();

    static {
        try {
            // 1. db.properties 로드 (classpath 기준)
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            if (in == null) throw new RuntimeException("❌ db.properties 파일을 찾을 수 없습니다.");
            props.load(in);
            in.close();

            // 2. JDBC 드라이버 로딩
            Class.forName(props.getProperty("driver"));

        } catch (Exception e) {
            throw new RuntimeException("❌ DB 설정 초기화 실패", e);
        }
    }

    // 3. 연결 제공 메서드
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                props.getProperty("url"),
                props.getProperty("user"),
                props.getProperty("password")
        );
    }
}
