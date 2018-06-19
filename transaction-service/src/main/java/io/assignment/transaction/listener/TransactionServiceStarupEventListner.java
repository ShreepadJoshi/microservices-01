/**
 * 
 */
package io.assignment.transaction.listener;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.assignment.transaction.api.v1.TransactionV1;

/**
 * @author Deepak Muthekar
 *
 */
@Component
public class TransactionServiceStarupEventListner {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private InMemoryTransactionDatabse imtd;

	@EventListener
	public void onApplicationStartup(ContextRefreshedEvent event) {
		LOGGER.info(
				"[TransactionServiceStarupEventListner] [onApplicationStartup(ContextRefreshedEvent event)] Application Satrted....");

		TransactionV1 transaction = new TransactionV1();
		transaction.setAccountId(new Long(1));
		transaction.setId(new Long(1));
		transaction.setAmount(new BigDecimal(100));
		transaction.setDate(new Date());

		imtd.addTransaction(transaction);
		LOGGER.info(
				"[TransactionServiceStarupEventListner] [onApplicationStartup(ContextRefreshedEvent event)] defualt customer added.");

	}
}
