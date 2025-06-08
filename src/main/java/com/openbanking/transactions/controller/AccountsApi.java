package com.openbanking.transactions.controller;

import com.openbanking.transactions.model.OBReadTransaction6;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "accounts", description = "accounts")
@RequestMapping(value = "")
public interface AccountsApi {

	@Operation(summary = "Get Transactions", operationId = "getAccountsAccountIdTransactions", description = "", tags = { "Transactions", })

	@RequestMapping(
			value = "/accounts/{AccountId}/transactions",
			produces = { "application/json; charset=utf-8", "application/json", "application/jose+jwe" },
			method = RequestMethod.GET)
	default ResponseEntity<OBReadTransaction6> getAccountsAccountIdTransactions(@Parameter(name = "AccountId", required = true)
	@PathVariable("AccountId")
	String accountId, @Parameter(name = "An Authorisation Token as per https://tools.ietf.org/html/rfc6750", required = true)
	@RequestHeader(value = "Authorization", required = true)
	String authorization, @Parameter(
			name = "The time when the PSU last logged in with the TPP.  All dates in the HTTP headers are represented as RFC 7231 Full Dates. An example is below:  Sun, 10 Sep 2017 19:43:31 UTC")
	@RequestHeader(value = "x-fapi-auth-date", required = false)
	String xFapiAuthDate, @Parameter(name = "The PSU's IP address if the PSU is currently logged in with the TPP.")
	@RequestHeader(value = "x-fapi-customer-ip-address", required = false)
	String xFapiCustomerIpAddress, @Parameter(name = "An RFC4122 UID used as a correlation id.")
	@RequestHeader(value = "x-fapi-interaction-id", required = false)
	String xFapiInteractionId, @Parameter(name = "Indicates the user-agent that the PSU is using.")
	@RequestHeader(value = "x-customer-user-agent", required = false)
	String xCustomerUserAgent, @Parameter(
			name = "The UTC ISO 8601 Date Time to filter transactions FROM NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component.")
	@RequestParam(value = "fromBookingDateTime", required = false)
	Date fromBookingDateTime, @Parameter(
			name = "The UTC ISO 8601 Date Time to filter transactions TO NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component.")
	@RequestParam(value = "toBookingDateTime", required = false)
	Date toBookingDateTime) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
