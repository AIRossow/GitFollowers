package com.centurylink.GitFollowers.com.centurylink.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.centurylink.GitFollowers.com.centurylink.dao.Users;

@Service
public class FollowerService {
	private final static String url = "https://api.github.com/users/";

	public Users getUsers(String userId) {
		
		
		Users baseUser = new Users();

		baseUser.setLogin(userId);

		List<Users> baseFollowers = getFollowers(userId);
		
		for( Users follower: baseFollowers)
		{
			follower.setFollowers(getFollowers(follower.getLogin()));
		}
		baseUser.setFollowers(baseFollowers);

		return baseUser;
	}

	public List<Users> getFollowers(String login) {
		String userUrl = url + login + "/following";
		
		List<Users> subFollowers = null;

		System.out.println("getting followers for " + login);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Users>> userResponse = restTemplate.exchange(userUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Users>>() {
				});
		List<Users> followers = userResponse.getBody();
		
		if(followers.size() > 5)
		{
			return followers.subList(0, 5);
		}
		else 
			return followers;
	}
}
