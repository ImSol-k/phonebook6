package com.javaex.controller;

import java.util.List;
import java.util.Map;

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
		System.out.println("Service:" + pList);// 확인용

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

		return "list";
	}

	/**********
	 * modify */
	// 수정폼
	@RequestMapping(value = "/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@ModelAttribute int no, Model model) {
		System.out.println("PhonebookController.modifyForm()");

		Map<String, Object> pMap = phonebookService.exeModifyForm(no);
		model.addAttribute("pMap", pMap);

		return "modifyForm";
	}
	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.modify()");

		phonebookService.exeModify(personVo);

		return "list";
	}

}
