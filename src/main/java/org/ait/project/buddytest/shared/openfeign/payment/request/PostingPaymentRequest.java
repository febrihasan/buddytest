package org.ait.project.buddytest.shared.openfeign.payment.request;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
public class PostingPaymentRequest {

  @JsonProperty("referenceNumber")
  private String referenceNumber;

  /*
   * Information Source Fund
   */
  @JsonProperty("sourceAccount")
  private String sourceAccount;
  @JsonProperty("senderName")
  private String senderName;
  @JsonProperty("senderBankCode")
  private String senderBankCode;
  @JsonProperty("senderBankName")
  private String senderBankName;

  /*
   * Information Source Fund
   */
  @JsonProperty("targetAccount")
  private String targetAccount;
  @JsonProperty("receiverName")
  private String receiverName;
  @JsonProperty("receiverBankCode")
  private String receiverBankCode;
  @JsonProperty("receiverBankName")
  private String receiverBankName;

  @JsonProperty("amount")
  private BigDecimal amount;
}
