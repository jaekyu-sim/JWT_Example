package com.example.demo.login;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.SecurityService;

@RestController
@RequestMapping("/login")
public class loginController {
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/create/token")
	public Map<String, Object> createToken(@RequestParam(value = "subject") String subject){
		String token = securityService.createToken(subject, (2*1000*60));
		
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result",  token);
		return map;
	}
	
	@GetMapping("/get/subject")
	public Map<String, Object> getSubject(@RequestParam(value = "token") String token){
		String subject = securityService.getSubject(token);
		
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result",  subject);
		return map;
	}
}
