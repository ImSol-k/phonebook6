package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트 =========================================================================
	public List<PersonVo> personSelect(){
		System.out.println("PhonebookDao.personSelect()");
		
		//sql문 받아와서 list에 저장
		List<PersonVo> pList = sqlSession.selectList("phonebook.select");
		return pList;
	}
	
	//추가 ===========================================================================
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");

		return sqlSession.insert("phonebook.insert", personVo);
	}
	
	//수정 ===========================================================================
	//수정할 레코드 찾기
	public PersonVo personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne()");
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);
		return personVo;
	}
	//정보 받아와서 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhonebookDao.personUpdate()");
		
		System.out.println("Dao: "+personVo);
		return sqlSession.update("phonebook.update", personVo);
	}
	
	//삭제 ===========================================================================
	public int personDelete(PersonVo personVo) {
		System.out.println("PhonebookDao.personDelete()");
		
		return sqlSession.delete("phonebook.delete", personVo);
	}
	

}
