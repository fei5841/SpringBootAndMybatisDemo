package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/index",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public List<User> index() {
		List<User> list=userMapper.selectAll();
		return list;
	}
	
	@RequestMapping(value="/index/{userid}",method=RequestMethod.GET)
	public User getUserById(@PathVariable(value="userid") int userid) {
		User user=userMapper.selectByPrimaryKey(userid);
		return user;
	}
	
	@RequestMapping(value="/{userid}",method=RequestMethod.GET)
	public String getUser(@PathVariable(value="userid") int userid) {
		User user=userMapper.selectByPrimaryKey(userid);
		return user.toString();
	}
	
	@RequestMapping(value="/username{name}",method=RequestMethod.GET)
	public List<User> getUserByUsername(@PathVariable(value="name") String name) {
		List<User> list=userMapper.getUserByUsername(name);
		return list;
	}
}
