/**
 * 
 */
package io.assignment.account.api.v1;

import java.util.List;

import io.assignment.account.entity.v1.CustomerEntityV1;

/**
 * 
 * @author Deepak Muthekar
 *
 */

public class CustomerResponseV1 {
	private Long id;
	private String firstName;
	private String lastName;
	private List<AccountResponseV1> accounts;

	public CustomerResponseV1(CustomerEntityV1 customerDetails, List<AccountResponseV1> accounts) {
		super();
		this.id = customerDetails.getId();
		this.firstName = customerDetails.getFirstName();
		this.lastName = customerDetails.getLastName();
		this.accounts = accounts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<AccountResponseV1> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountResponseV1> accounts) {
		this.accounts = accounts;
	}

}
