package com.news.repository.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
public class AppConfig {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<MainMenu> getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(List<MainMenu> mainMenu) {
		this.mainMenu = mainMenu;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@PrimaryKey
	private Integer id;
	private List<MainMenu> mainMenu;
	private String message;

	public AppConfig() {
	}
}
