package com.jalo.mis.oa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.jalo.commons.webservice.model.Result;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/get")
	public @ResponseBody Result<String> get() {
		return new Result<>(true, false, "success");
	}
	
}
