package io.assignment.account.entity.v1;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author Deepak Muthekar
 *
 */
@Data
@Builder
public class CustomerEntityV1 {
	private Long id;
	private String firstName;
	private String lastName;
	private List<AccountEntityV1> accounts;

}
