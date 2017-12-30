package com.jalo.mis.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jalo.mis.oa.entity.UserEntity;
import com.jalo.mis.oa.model.User;
import com.jalo.mis.oa.service.UserService;

/**
 * Controller : user
 * 
 * @author Jalo Asus
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public @ResponseBody List<UserEntity> findAll(HttpServletRequest request, HttpServletResponse response) {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody UserEntity find(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		return userService.findOne(id);
	}

	@PostMapping("")
	public @ResponseBody UserEntity saveOrUpdate(@RequestBody User model, HttpServletRequest request,
			HttpServletResponse response) {
		return userService.saveOrUpdate(model);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody Long delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		return userService.delete(id);
	}
}
