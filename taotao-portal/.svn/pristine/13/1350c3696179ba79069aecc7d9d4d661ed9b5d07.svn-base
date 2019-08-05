package com.taotao.portal.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.service.ContentService;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;
	
//	@RequestMapping("/index")
//	public String showIndex() {
//		return "index";
//	}

	@RequestMapping(value = "/httpclient/post", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult testPost() {
		return TaotaoResult.ok();
		//return "OK";
	}
	
	@RequestMapping("/index")
	public String showIndex(Model model) {
		String adJson = contentService.getContentList();
		model.addAttribute("ad1", adJson);
		
		return "index";
	}
	
	@RequestMapping(value = "/httpclient/postparam", method = RequestMethod.POST,produces="application/json" + ";charset=utf-8")
	@ResponseBody
	public TaotaoResult testPostParam(String username,String password) {
		String result="{username:'"+username+"',password:'"+password+"'}";
		System.out.println(result);
		return TaotaoResult.ok(result);
	}
}
