package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "hello-world-form";
	}

	@RequestMapping("/processFormVersionOne")
	public String processFormOne()
	{
		return "helloworld";
	}
	
	@RequestMapping("processFormVersionTwo")
	public String processFormTwo(HttpServletRequest request,Model model)
	{
		String stdName=request.getParameter("studentName");
		stdName=stdName.toUpperCase();
		String finalString=" name is converted to upper case version Two : "+stdName;
		model.addAttribute("message",finalString);
		return "helloworld";
	}
	
	@RequestMapping("processFormVersionThree")
	public String processFormThree(@RequestParam("studentName") String stdName,Model model)
	{
		stdName=stdName.toUpperCase();
		String finalString=" name is converted to upper case version Three : "+stdName;
		model.addAttribute("message",finalString);
		return "helloworld";
	}

}
