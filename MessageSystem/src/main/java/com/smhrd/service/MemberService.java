package com.smhrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.WebMember;

//데이터를 전달받아 가공하는 역할(POJO 형태로 전달)
@Service
public class MemberService {

	// controller -> service -> mapper

	@Autowired
	MemberMapper memberMapper;

	// 회원가입 service
	public void joinMember(WebMember member) {
		memberMapper.joinMember(member);
	}

	// 로그인 service
	public WebMember loginMember(WebMember member) {
		WebMember loginM = memberMapper.loginMember(member);
		return loginM;
	}
	
	public void updateMember(WebMember member) {
		memberMapper.updateMember(member);
	}
	
	public List<WebMember> selectMember() {
		List<WebMember> memberList = memberMapper.selectAllMember();
		
		return memberList;
		// return memberMapper.selectAllMember();
	}
	
	public void deleteMember(String email) {
		memberMapper.deleteMember(email);
	}
	
}
