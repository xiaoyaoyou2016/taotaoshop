package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * @author zhoulinbin
 *
 */

@Controller
public class PageController {

	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String ShowIndex(){
		
		return "index";
	}
	
	/**
	 * 展示其它页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String ShowPage(@PathVariable String page){
		
		return page;
	}
}
