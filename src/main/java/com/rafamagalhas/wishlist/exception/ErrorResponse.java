package com.rafamagalhas.wishlist.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	private Date timestamps;
	private String status;
	private String message;
	private String details;
}
