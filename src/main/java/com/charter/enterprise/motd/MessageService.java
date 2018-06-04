package com.charter.enterprise.motd;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private final String sampleMsg = "Welcome to Charter. All systems are nominal.";

	public String getDailyMessage() {
		return sampleMsg;
	}

}
