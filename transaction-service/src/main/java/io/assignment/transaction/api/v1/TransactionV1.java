package io.assignment.transaction.api.v1;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TransactionV1 {
	private Long id;
	private Long accountId;
	private Date date;
	private BigDecimal amount;
	
	public TransactionV1() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
}
