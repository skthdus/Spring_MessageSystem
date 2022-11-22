package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		//model -> service로 전달
		memberService.joinMember(member);
		model.addAttribute("joinM", member);
		return "joinSuccess";
	}
	
	@PostMapping("/member/login")
	public String login(@ModelAttribute WebMember member, HttpSession session) {
		WebMember loginM = memberService.loginMember(member); // 받아준 데이터 넘겨줌
		session.setAttribute("loginM", loginM);
		return "main";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginM");
		return "redirect:/main";
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute WebMember member, HttpSession session) {
		
		WebMember loginM = (WebMember) session.getAttribute("loginM");
		String email = loginM.getEmail(); //현재 로그인한 사용자의 이메일 -> 현재 이 사용자의 정보만 수정
		member.setEmail(email); // 비워져 있는 email 필드 채우기 > Session에서 가져옴
		
		memberService.updateMember(member);
		session.setAttribute("loginM", member);
		return "redirect:/main";
	}
	
	@GetMapping("/member/selectAllMember")
	public String selectAllMember(Model model) {
		List<WebMember> memberList = memberService.selectMember();
		
		model.addAttribute("memberList", memberList);
		
		return "selectMember";
	}
	
	//PathVariable : restAPI 에서 URI 에 변수가 들어가 있을 때 처리
		@GetMapping("/member/deleteMember/{email}")
		public String delete(@PathVariable("email") String email) {
			memberService.deleteMember(email);
			return "redirect:/selectMember";
		}
	}











