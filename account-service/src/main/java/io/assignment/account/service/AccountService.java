/**
 * 
 */
package io.assignment.account.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.assignment.account.api.v1.AccountOpeningRequestV1;
import io.assignment.account.api.v1.AccountResponseV1;
import io.assignment.account.api.v1.CustomerResponseV1;
import io.assignment.account.client.TransactionServiceClient;
import io.assignment.account.client.TransactionV1;
import io.assignment.account.entity.v1.AccountEntityV1;
import io.assignment.account.entity.v1.CustomerEntityV1;
import io.assignment.account.exception.CustomerNotFoundException;
import io.assignment.account.listener.InMemoryCustomerDatabse;

/**
 * @author Deepak Muthekar
 *
 */
@Service
public class AccountService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TransactionServiceClient transactionServiceProxy;
	@Autowired
	private InMemoryCustomerDatabse imcd;

	public CustomerResponseV1 getCustomerById(Long customerId) {
		LOGGER.info("[AccountService][getCustomerById(Long customerId)]: For customer id {}", customerId);
		if (imcd.selectById(customerId) == null)
			throw new CustomerNotFoundException("Custmor with id " + customerId + "not found");

		CustomerEntityV1 customer = imcd.selectById(customerId);
		List<AccountResponseV1> accountDetails = getCustomerAccountDetails(customer);
		return new CustomerResponseV1(customer, accountDetails);

	}

	private List<AccountResponseV1> getCustomerAccountDetails(CustomerEntityV1 customer) {
		LOGGER.info("[AccountService][getCustomerAccountDetails(CustomerEntityV1 customer)]: For customer id {}",
				customer.getId());

		List<AccountEntityV1> accounts = customer.getAccounts();

		List<AccountResponseV1> accountDetails = new ArrayList<>();
		for (AccountEntityV1 account : accounts) {
			List<TransactionV1> transactions = transactionServiceProxy.forAccountId(account.getId());
			AccountResponseV1 accountResponse = new AccountResponseV1(account, transactions);
			accountDetails.add(accountResponse);
		}
		return accountDetails;
	}

	public CustomerEntityV1 openAccount(AccountOpeningRequestV1 accountOpeningRequest) {
		LOGGER.info(
				"[AccountService][openAccount(AccountOpeningRequestV1 accountOpeningRequest)]: Opeining account for customer id  {}",
				accountOpeningRequest.getCustomerId());
		if (imcd.selectById(accountOpeningRequest.getCustomerId()) == null)
			throw new CustomerNotFoundException("Custmor not found");

		// Create new Account
		AccountEntityV1 newAccount = createNewAccount();
		imcd.addNewCustomerAccount(accountOpeningRequest.getCustomerId(), newAccount);

		// Create Transaction
		if (accountOpeningRequest.isInitialCreditPresent()) {
			TransactionV1 transaction = new TransactionV1(null, newAccount.getId(), new Date(),
					accountOpeningRequest.getInitialCredit());
			transactionServiceProxy.createTransaction(transaction);
		}
		return imcd.selectById(accountOpeningRequest.getCustomerId());

	}

	private AccountEntityV1 createNewAccount() {
		LOGGER.info("[AccountService]createNewAccount()]: building account");

		AccountEntityV1 newAccount = AccountEntityV1.builder().openingDate(new Date()).build();
		return newAccount;
	}

}
