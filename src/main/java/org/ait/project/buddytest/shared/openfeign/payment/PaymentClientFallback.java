package org.ait.project.buddytest.shared.openfeign.payment;

import org.ait.project.buddytest.shared.openfeign.payment.request.PostingPaymentRequest;
import org.ait.project.buddytest.shared.openfeign.payment.response.PostingPaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentClientFallback implements PaymentClient {

  /**.
   * When Openfeign Call failed, then do this
   */

  @Override
  public PostingPaymentResponse postingPayment(PostingPaymentRequest paymentRequest) {
    return null;
  }

  @Override
  public PostingPaymentResponse previewPayment(String referenceNumber) {
    return null;
  }

  @Override
  public PostingPaymentResponse cancelPayment(String referenceNumber) {
    return null;
  }
}
