/**
 * 
 */
package io.assignment.account.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.assignment.account.entity.v1.AccountEntityV1;
import io.assignment.account.entity.v1.CustomerEntityV1;

/**
 * @author Deepak Muthekar
 *
 */
@Component
public class ApplicationStarupEventListner {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private InMemoryCustomerDatabse imcd;

	@EventListener
	public void onApplicationStartup(ContextRefreshedEvent event) {
		LOGGER.info(
				"[ApplicationStarupEventListner] [onApplicationStartup(ContextRefreshedEvent event)] Application Satrted....");

		AccountEntityV1 account = AccountEntityV1.builder()
				.openingDate(new Date())
				.build();
		
		List<AccountEntityV1> accounts = new ArrayList<>();
		accounts.add(account);

		CustomerEntityV1 customer = CustomerEntityV1.builder()
				.firstName("Deepak")
				.lastName("Muthekar")
				.accounts(accounts)
				.build();
		imcd.addCustomer(customer);
		LOGGER.info(
				"[ApplicationStarupEventListner] [onApplicationStartup(ContextRefreshedEvent event)] defualt customer added.");

	}
}
