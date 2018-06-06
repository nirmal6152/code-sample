package com.charter.enterprise.motd;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private String dailyMessage = "Welcome to Charter. All systems are nominal.";

	public String getDailyMessage() {
		return dailyMessage;
	}

	public void setDailyMessage(String dailyMessage) {
		this.dailyMessage = dailyMessage;
	}

}
