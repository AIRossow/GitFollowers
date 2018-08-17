package com.centurylink.GitFollowers.com.centurylink.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {

	private String login;
	
	private List<Users> followers;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Users> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Users> followers) {
		this.followers = followers;
	}
}
