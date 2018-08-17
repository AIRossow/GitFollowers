package com.centurylink.GitFollowers.com.centurylink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centurylink.GitFollowers.com.centurylink.dao.Users;
import com.centurylink.GitFollowers.com.centurylink.service.FollowerService;

@RestController
//@RequestMapping("followers")
public class FollowerController {

//	private String url = "https://api.github.com/users/resisttheurge/following";
	
	@Autowired
	private FollowerService followerServ;
	
	public FollowerController(FollowerService followerService)
	{
		this.followerServ = followerService;
	}
	
	@GetMapping("/getFollowers/{userId}")
	public Users getFollowers(@PathVariable String userId){
		
		System.out.println("here is the userId" + userId);
		
		Users followers = followerServ.getUsers(userId);
		
		return followers;
	}
}
