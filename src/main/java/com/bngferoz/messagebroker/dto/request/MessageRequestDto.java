package com.bngferoz.messagebroker.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2503344413305051763L;
	private String messageId;
	private String message;
	private LocalDateTime timeStamp;
}
