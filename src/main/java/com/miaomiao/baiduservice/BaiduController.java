package com.miaomiao.baiduservice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaiduController {
	
	// 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
	private static final String APP_ID = "20191112000356065";
	private static final String SECURITY_KEY = "s5I1EqAFTtdfgVtBcOdw";
	
	@ResponseBody
	@PostMapping(value="/json/translation", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getByJson(@RequestBody String query) {
		System.out.println(query);
		TransApi api = new TransApi(APP_ID, SECURITY_KEY);
		String result_string = api.getTransResult(query.replace("\"", ""), "auto", "en");
		System.out.println(result_string);
		return result_string;
	}
	
	@ResponseBody
	@GetMapping(value="/json/translation")
	public String get(HttpServletRequest request) {
		String query = request.getParameter("query");
		System.out.println(query);
		
		TransApi api = new TransApi(APP_ID, SECURITY_KEY);
		String result_string = api.getTransResult(query, "auto", "en");
		
		System.out.println(result_string);
		return result_string;
	}
}
