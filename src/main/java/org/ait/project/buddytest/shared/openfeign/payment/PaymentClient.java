package org.ait.project.buddytest.shared.openfeign.payment;

import org.ait.project.buddytest.shared.openfeign.payment.common.PathPaymentClientAPIs;
import org.ait.project.buddytest.shared.openfeign.payment.request.PostingPaymentRequest;
import org.ait.project.buddytest.shared.openfeign.payment.response.PostingPaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    value = "payment-client",
    url = "${restclient.url.payment-client}",
    fallback = PaymentClientFallback.class
)
public interface PaymentClient {

  /**.
   * Api external for posting payment
   * @param paymentRequest
   * @return response payment
   */
  @PostMapping(PathPaymentClientAPIs.POSTING)
  PostingPaymentResponse postingPayment(@RequestBody PostingPaymentRequest paymentRequest);

  /**.
   * Api external for preview / check status payment
   * @param referenceNumber
   * @return response payment
   */
  @GetMapping(PathPaymentClientAPIs.PREVIEW)
  PostingPaymentResponse previewPayment(@PathVariable String referenceNumber);

  /**.
   * Api external for cancel payment
   * @param referenceNumber
   * @return response payment
   */
  @DeleteMapping(PathPaymentClientAPIs.CANCEL)
  PostingPaymentResponse cancelPayment(@PathVariable String referenceNumber);
}
