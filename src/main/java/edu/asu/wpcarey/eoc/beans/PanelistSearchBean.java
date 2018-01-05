package edu.asu.wpcarey.eoc.beans;

import org.apache.commons.lang3.StringUtils;

public class PanelistSearchBean {
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String state;
	private String Organization;
	private String id;
	private ResponseState responseState;
	private String mailingId;
	private String contactId;

	public enum ResponseState {
		OK, NO_DATA, ERROR
	};

	public PanelistSearchBean(String[] data) {
		if (data[0].equals(StringUtils.EMPTY)) {
			responseState = ResponseState.NO_DATA;
		} else if (data[0].equals("error")) {
			responseState = ResponseState.ERROR;
		} else {
			responseState = ResponseState.OK;
			setId(data[0]);
			setFirstName(data[1]);
			setLastName(data[2]);
			setEmailAddress(data[3]);
			setOrganization(data[4]);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrganization() {
		return Organization;
	}

	public void setOrganization(String organization) {
		Organization = organization;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResponseState getResponseState() {
		return responseState;
	}

	public void setResponseState(ResponseState responseState) {
		this.responseState = responseState;
	}

	public String getMailingId() {
		return mailingId;
	}

	public void setMailingId(String mailingId) {
		this.mailingId = mailingId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

}
