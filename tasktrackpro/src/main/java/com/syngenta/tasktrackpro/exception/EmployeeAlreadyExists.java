package com.syngenta.tasktrackpro.exception;

public class EmployeeAlreadyExists extends RuntimeException {

	public EmployeeAlreadyExists(String message)
	{
		super(message);
	}
}
