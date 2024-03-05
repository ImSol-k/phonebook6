package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	public List<PersonVo> exeList(){
		System.out.println("PhonebookService.exeList()");
		
		//리스트에 저장
		List<PersonVo> pList = phonebookDao.personSelect();
		
		return pList;
	}
	
	//추가
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		
		int count = phonebookDao.personInsert(personVo);
		return count;
	}
	
}
