/**
 * 
 */
package io.assignment.transaction.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import io.assignment.transaction.api.v1.TransactionV1;

/**
 * @author Deepak Muthekar
 *
 */
@ApplicationScope
@Component
public class InMemoryTransactionDatabse {
	private AtomicLong transactionId = new AtomicLong(0);
	/**
	 * KEY= Unique account id
	 * </p>
	 * Value = List of Transactions belongs to the account
	 */
	private Map<Long, List<TransactionV1>> accountIdTransactionsMap = new HashMap<>();

	public void addTransaction(TransactionV1 transaction) {
		if (!accountIdTransactionsMap.containsKey(transaction.getAccountId())) {
			List<TransactionV1> transactions = new ArrayList<>();
			transaction.setId(transactionId.incrementAndGet());
			transaction.setDate(new Date());
			transactions.add(transaction);
			this.accountIdTransactionsMap.put(transaction.getAccountId(), transactions);
		} else {
			List<TransactionV1> transactions = accountIdTransactionsMap.get(transaction.getAccountId());
			transaction.setId(transactionId.incrementAndGet());
			transaction.setDate(new Date());
			transactions.add(transaction);
		}

	}

	public List<TransactionV1> byAccountId(Long accountId) {
		return accountIdTransactionsMap.get(accountId);
	}

}
