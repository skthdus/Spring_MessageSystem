package com.smhrd.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		return "main";
	}
	
	//update 페이지를 보여주는 메서드
		@GetMapping("/update")
		public String updatePage() {
			return "update";
		}
}
