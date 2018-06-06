package com.charter.enterprise.motd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MotdController {

	@Autowired
	private MessageService messageService;

	@GetMapping
	public String getMotd() {
		return messageService.getDailyMessage();
	}

	@PutMapping("/update")
	public ResponseEntity<String> setMotd(@RequestBody String updMessage) {
		String resp = null;
		HttpStatus httpStatus = null;

		if (updMessage != null) {
			httpStatus = HttpStatus.ACCEPTED;
			resp = httpStatus.toString();
			messageService.setDailyMessage(updMessage);
		}

		return new ResponseEntity<>(resp, httpStatus);
	}

}
