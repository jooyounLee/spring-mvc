package kr.mz.study.spring.auth.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.mz.study.spring.auth.model.UserModel;

@Repository
public class UserRepository {
	
	@Autowired 
	private SqlSession sqlSession;
	
	public UserModel findByUsername(String username) {
		return sqlSession.selectOne("user.selectByUsername", username);
	}
}
