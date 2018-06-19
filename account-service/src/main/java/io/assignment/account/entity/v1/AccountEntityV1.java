/**
 * 
 */
package io.assignment.account.entity.v1;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * @author Deepak Muthekar
 *
 */
@Data
@Builder
public class AccountEntityV1 {
	private Long id;
	private Date openingDate;
}
