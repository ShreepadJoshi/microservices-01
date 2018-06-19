/**
 * 
 */
package io.assignment.transaction.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.assignment.transaction.api.v1.TransactionV1;
import io.assignment.transaction.listener.InMemoryTransactionDatabse;

/**
 * @author Deepak Muthekar
 *
 */
@RestController
@RequestMapping("/api")
public class TransactionResource {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InMemoryTransactionDatabse imtd;

	@GetMapping("/v1/transactions/{accountId}")
	public List<TransactionV1> finfById(@PathVariable("accountId") Long accountId) {
		LOGGER.info(
				"[TransactionResource][finfById(@PathVariable(accountId) Long accountId)]: findinf transactions for account id {}",
				accountId);
		return imtd.byAccountId(accountId);
	}

	@PostMapping("/v1/transactions")
	public List<TransactionV1> createTransaction(@RequestBody TransactionV1 transaction) {
		LOGGER.info(
				"[TransactionResource][createTransaction(@RequestBody TransactionV1 transaction)]: creating new transaction for account id {}",
				transaction.getAccountId());

		imtd.addTransaction(transaction);
		return imtd.byAccountId(transaction.getAccountId());
	}
}
