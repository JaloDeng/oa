package com.jalo.mis.oa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jalo.mis.oa.entity.UserEntity;
import com.jalo.mis.oa.model.User;
import com.jalo.mis.oa.service.UserService;

import top.jalo.commons.webservice.model.Result;

/**
 * Controller : user
 * @author Jalo
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public @ResponseBody List<UserEntity> userAll() {
		return userService.findAll();
	}
	
	@GetMapping("/getone/{id}")
	public Result<UserEntity> getOne(@PathVariable Long id, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return new Result<UserEntity>(userService.findOne(id));
	}
	
	@GetMapping
	public ModelAndView findAll(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("list", userService.findAll());
		model.addAttribute("title", "用户列表");
		return new ModelAndView("oa/list", "result", model);
	}
	
	@GetMapping("/{id}")
	public ModelAndView find(@PathVariable Long id, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("user", userService.findOne(id));
		model.addAttribute("title", "查看用户");
		return new ModelAndView("oa/view", "result", model);
	}

	@GetMapping("/form")
	public ModelAndView form(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "创建用户");
		return new ModelAndView("oa/form", "result", model);
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView form(@PathVariable Long id, Model model,  HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("user", userService.findOne(id));
		model.addAttribute("title", "修改用户");
		return new ModelAndView("oa/form", "result", model);
	}
	
	@PostMapping
	public ModelAndView saveOrUpdate(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
		userService.saveOrUpdate(user);
		return new ModelAndView("redirect:/user");
	}
	
	@PostMapping("/form")
	public ModelAndView saveOrUpdateForm(User user, HttpServletRequest request, HttpServletResponse response) {
		userService.saveOrUpdate(user);
		return new ModelAndView("redirect:/user");
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		userService.delete(id);
		try {
			response.sendRedirect("/user");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView deleteByMethodGet(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		userService.delete(id);
		return new ModelAndView("redirect:/user");
	}
}
