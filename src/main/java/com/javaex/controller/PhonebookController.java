package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	/********
	 * list
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhonebookController.list()");

		// 리스트에 저장
		List<PersonVo> pList = phonebookService.exeList();

		// model에 pList로 추가
		model.addAttribute("pList", pList);

		return "list";
	}

	/*********
	 * write
	 */
	// 추가폼
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		return "writeForm";
	}

	// 추가
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");

		phonebookService.exeWrite(personVo);

		return "redirect:/list";
	}

	/**********
	 * modify */
	// 수정폼
	@RequestMapping(value = "/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("PhonebookController.modifyForm()");

		PersonVo personVo = phonebookService.exeModifyForm(no);
		System.out.println("modifyform: "+personVo);
		model.addAttribute("personVo", personVo);

		return "modifyForm";
	}
	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.modify()");

		System.out.println("Controller: "+personVo);
		phonebookService.exeModify(personVo);
		return "redirect:/list";
	}
	
	/**********
	 * delete */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.delete()");
		
		phonebookService.exeDelete(personVo);
		
		return "redirect:/list";
	}
	
	
}
