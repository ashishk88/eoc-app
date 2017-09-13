package edu.asu.wpcarey.eoc.beans;

public class ResponseView {

	enum Status {
		SUCCESS, FAILURE, ERROR
	}

	private Status status;

	private String message;

	private ResponseView() {
		status = Status.SUCCESS;
	}

	public ResponseView(final Status status, final String message) {
		this.status = status;
		this.message = message;
	}

	private ResponseView(final String message) {
		status = Status.SUCCESS;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Status getStatus() {
		return status;
	}

	public ResponseView setMessage(final String message) {
		this.message = message;
		return this;
	}

	public void setStatus(final Status status) {
		this.status = status;
	}
}
