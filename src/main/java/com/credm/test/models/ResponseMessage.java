package com.credm.test.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {
	private long errorCode ;
	private String errorMessage;
}
