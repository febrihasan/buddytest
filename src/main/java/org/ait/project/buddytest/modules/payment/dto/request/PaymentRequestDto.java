package org.ait.project.buddytest.modules.payment.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class PaymentRequestDto {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("customer_id")
    private final Long customerId;
    @JsonProperty("order_id")
    private final Long orderId;
    @JsonProperty("transaction_date")
    private final ZonedDateTime transactionDate;
    @JsonProperty("amount")
    private final BigDecimal amount;
    @JsonProperty("reference_number")
    private final String referenceNumber;
    @JsonProperty("sourceAccount")
    private final String sourceAccount;
    @JsonProperty("sender_name")
    private final String senderName;
    @JsonProperty("sender_bank_code")
    private final String senderBankCode;
    @JsonProperty("sender_bank_name")
    private final String senderBankName;
    @JsonProperty("target_account")
    private final String targetAccount;
    @JsonProperty("receiver_name")
    private final String receiverName;
    @JsonProperty("receiver_bank_code")
    private final String receiverBankCode;
    @JsonProperty("receiver_bank_name")
    private final String receiverBankName;
    @JsonProperty("status")
    private final String status;
    @JsonProperty("description")
    private final String description;
}
