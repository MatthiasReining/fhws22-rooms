package de.fhws.basics.cdi;

import java.util.Date;

import javax.annotation.PostConstruct;

public class Message {

	private String text;

	public Message() {
		System.out.println("Message#constructor");
	}

	@PostConstruct
	void init() {
		this.text = "default: " + new Date() + " ns" + System.nanoTime();
		System.out.println("Message#init");
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
