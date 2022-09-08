package org.ait.project.buddytest.shared.openfeign.payment;

import org.ait.project.buddytest.shared.openfeign.payment.request.PostingPaymentRequest;
import org.ait.project.buddytest.shared.openfeign.payment.response.PostingPaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentClientFallback implements PaymentClient {

  /**.
   * When Openfeign Call failed, then do this
   */

  /**.
   * Posting payment to api external
   * @param paymentRequest
   * @return data payment
   */
  @Override
  public PostingPaymentResponse postingPayment(final PostingPaymentRequest paymentRequest) {
    return new PostingPaymentResponse();
  }

  /**.
   * Preview payment to api external
   * @param referenceNumber
   * @return data payment
   */
  @Override
  public PostingPaymentResponse previewPayment(final String referenceNumber) {
    return new PostingPaymentResponse();
  }

  /**.
   * Cancel payment to api external
   * @param referenceNumber
   * @return data payment
   */
  @Override
  public PostingPaymentResponse cancelPayment(final String referenceNumber) {
    return new PostingPaymentResponse();
  }
}
