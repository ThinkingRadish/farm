package com.news.web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="text")
public class TextEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String text;

	public TextEntity(){
		super();
	}

	public TextEntity(String name, String text){
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}


}
