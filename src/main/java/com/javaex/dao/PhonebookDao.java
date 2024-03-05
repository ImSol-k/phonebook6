package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트
	public List<PersonVo> personSelect(){
		System.out.println("PhonebookDao.personSelect()");
		
		//sql문 받아와서 list에 저장
		List<PersonVo> pList = sqlSession.selectList("phonebook.select");
		
		return pList;
	}
	
	//추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");

		return sqlSession.insert("phonebook.insert", personVo);
	}
	
	public Map<String, Object> personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne()");
		
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne", no);
		
		return pMap;
	}
	
	public int personUpdate(PersonVo personVo) {

		return sqlSession.update("phonebook.update", personVo);
	}
	

}
