package io.assignment.account.client;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionV1 {
	private Long id;
	private Long accountId;
	private Date date;
	private BigDecimal amount;

	public TransactionV1() {}

	public TransactionV1(Long id, Long accountId, Date date, BigDecimal amount) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.date = date;
		this.amount = amount;
	}

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
