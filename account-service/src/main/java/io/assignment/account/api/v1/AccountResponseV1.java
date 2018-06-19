/**
 * 
 */
package io.assignment.account.api.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import io.assignment.account.client.TransactionV1;
import io.assignment.account.entity.v1.AccountEntityV1;
import lombok.Data;

/**
 * @author Deepak Muthekar
 *
 */

public class AccountResponseV1 {
	private Long id;
	private Date openingDate;
	private List<TransactionV1> transactions = new ArrayList<>();
	private BigDecimal balance;

	public AccountResponseV1(AccountEntityV1 account, List<TransactionV1> transactions) {
		this.id = account.getId();
		this.openingDate = account.getOpeningDate();
		if (transactions != null)
			this.transactions = transactions;
		this.balance = this.balance();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public List<TransactionV1> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionV1> transactions) {
		this.transactions = transactions;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	private BigDecimal balance() {
		BigDecimal totalBalance = new BigDecimal(0);
		for (TransactionV1 transaction : transactions) {
			if (transaction.getAmount() != null)
				totalBalance = totalBalance.add(transaction.getAmount());
		}
		return totalBalance;
	}
}
