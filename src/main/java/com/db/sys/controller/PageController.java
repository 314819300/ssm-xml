package com.db.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {
	
	@RequestMapping("doLoginUI")
	  public String doLoginUI(){
		  return "login";
	  }

	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
		// 返回值会给dispatcherServlet
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	

}
