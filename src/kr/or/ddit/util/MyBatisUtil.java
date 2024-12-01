package kr.or.ddit.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			// 1-1 xml설정 파일 읽어오기
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");

			// 1-2 위에서 읽어온 Reader객체를 이용하여 SqlSessionFactory 객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * SqlSession 객체를 제공하기 위한 팩토리 메서드
	 * @return SqlSession객체
	 */
	public static SqlSession getSQLSession() {
		
		return sqlSessionFactory.openSession();
	}
	
	/**
	 * SqlSession 객체를 제공하기 위한 팩토리 메서드
	 * @param autoCommit 오토커밋여부
	 * @return SqlSession객체
	 */
	public static SqlSession getSQLSession(boolean autoCommit) {
		return sqlSessionFactory.openSession(autoCommit);
	}
}
