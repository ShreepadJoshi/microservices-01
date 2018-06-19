/**
 * 
 */
package io.assignment.account.api.v1;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * @author Deepak Muthekar
 *
 */
@Component
public class AccountOpeningRequestV1 {
	private Long customerId;
	private BigDecimal initialCredit;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(BigDecimal initialCredit) {
		this.initialCredit = initialCredit;
	}

	public boolean isInitialCreditPresent() {
		if (this.initialCredit != null && this.initialCredit.intValue() > 0)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
}
