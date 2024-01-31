package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SqlSessionTemplate = MyBatis에서 사용됨.
public class SqlSessionTemplate {

    public static SqlSession getSqlSession() {
        SqlSession session = null;
        String resource = "mybatis-config.xml"; 
        try {
            InputStream is = Resources.getResourceAsStream(resource);     // 설정파일 연결 1
            SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder(); // 설정파일 연결 2
            SqlSessionFactory factory = bulider.build(is);    // 설정파일 연결 3
            session = factory.openSession();    // Session 연결구문
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

}