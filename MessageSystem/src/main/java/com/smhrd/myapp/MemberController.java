package com.smhrd.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.model.WebMember;
import com.smhrd.service.MemberService;

//요청/응답(view 반환)
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("/member/join")
	public String join(@ModelAttribute WebMember member, Model model) {
		//model-> service로 전달
		memberService.joinMember(member);
		model.addAttribute("joinM", member);
		return "joinSuccess";
	}
}
