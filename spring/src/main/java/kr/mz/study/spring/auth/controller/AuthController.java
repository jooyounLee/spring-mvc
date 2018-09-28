package kr.mz.study.spring.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	@RequestMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error,
							  @RequestParam(value="logout", required=false) String logout,
							  Model model) {
		if(error != null) {
			model.addAttribute("error", "아이디와 비밀번호를 확인해주세요.");
		}
		if(logout != null) {
			model.addAttribute("msg", "로그아웃 성공");
		}
		
		return "login";
	}
}
