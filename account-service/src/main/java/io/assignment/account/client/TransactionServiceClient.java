/**
 * 
 */
package io.assignment.account.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface acts as a proxy for transaction-service.
 * </p>
 * Note: FeignClient does not directly connect to transaction-service but to
 * api-gateway-server. so every call to transaction-service get routed through
 * api-gateway-server and we get opportunity to put common logic in
 * api-gateway-server for every microservice like logging, metric collection,
 * authentication and authorization.
 * </p>
 * 
 * </p>
 * RibbonClient also dynamically discover transaction-service instances from
 * Eureka naming server and connect them dynamically. IF you see in
 * application.properties there is no hard coded instances of
 * transaction-service with property
 * transaction-service.ribbon.listOfServers=endpoint1,endpoint2
 * 
 * 
 * @author Deepak Muthekar
 *
 */
@FeignClient(name = "api-gateway-server")
@RibbonClient(name = "transaction-service")

public interface TransactionServiceClient {
	@GetMapping("/transaction-service/api/v1/transactions/{accountId}")
	public List<TransactionV1> forAccountId(@PathVariable("accountId") Long accountId);

	@PostMapping("/transaction-service/api/v1/transactions")
	public List<TransactionV1> createTransaction(@RequestBody TransactionV1 transaction);
}
