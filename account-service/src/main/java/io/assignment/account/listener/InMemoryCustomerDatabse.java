/**
 * 
 */
package io.assignment.account.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import io.assignment.account.entity.v1.AccountEntityV1;
import io.assignment.account.entity.v1.CustomerEntityV1;

/**
 * @author Deepak Muthekar
 *
 */
@ApplicationScope
@Component
public class InMemoryCustomerDatabse {

	private AtomicLong accountId = new AtomicLong(0);
	private AtomicLong customerId = new AtomicLong(0);

	private Map<Long, CustomerEntityV1> customerMap = new HashMap<>();

	public void addCustomer(CustomerEntityV1 customer) {
		customer.setId(customerId.incrementAndGet());
		if (customer.getAccounts() != null && customer.getAccounts().size() > 0) {
			for (AccountEntityV1 account : customer.getAccounts()) {
				account.setId(accountId.incrementAndGet());
			}
		}
		customerMap.put(customer.getId(), customer);
	}

	public CustomerEntityV1 selectById(Long id) {
		return customerMap.get(id);
	}

	/**
	 * Add New Account to existing customer with unique customer id
	 * 
	 * @param customerId
	 * @param account
	 */
	public void addNewCustomerAccount(Long customerId, AccountEntityV1 account) {
		if (customerMap.containsKey(customerId)) {
			CustomerEntityV1 customerEntityV1 = customerMap.get(customerId);
			account.setId(accountId.incrementAndGet());
			customerEntityV1.getAccounts().add(account);
		}
	}
}
