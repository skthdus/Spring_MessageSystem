package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.WebMember;

//mapper interface 지정
@Mapper
public interface MemberMapper {
	
	public void joinMember(WebMember member);
}
