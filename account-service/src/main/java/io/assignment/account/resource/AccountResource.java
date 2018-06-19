/**
 * 
 */
package io.assignment.account.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.assignment.account.api.v1.AccountOpeningRequestV1;
import io.assignment.account.api.v1.CustomerResponseV1;
import io.assignment.account.entity.v1.CustomerEntityV1;
import io.assignment.account.service.AccountService;

/**
 * @author Deepak Muthekar
 *
 */
@RestController
@RequestMapping("/api")
public class AccountResource {
	@Autowired
	private AccountService accountService;

	@GetMapping("/v1/accounts/{customerId}")
	public CustomerResponseV1 customerAccountDetails(@PathVariable Long customerId) {
		return accountService.getCustomerById(customerId);
	}

	@PostMapping("/v1/accounts")
	public CustomerEntityV1 openAccount(@RequestBody AccountOpeningRequestV1 accountOpeningRequest) {
		return accountService.openAccount(accountOpeningRequest);
	}
}
