package org.ait.project.buddytest.modules.payment.service.internal;

import org.ait.project.buddytest.modules.payment.dto.request.PaymentRequestDto;
import org.ait.project.buddytest.modules.payment.dto.response.PaymentResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.http.ResponseEntity;

/**.
 * Interface Product Service
 */
public interface PaymentService {

    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
    createPayment(PaymentRequestDto paymentDto);

    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
    previewPayment(String referenceNumber);

    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
    postingPayment(String referenceNumber);

    public void cancelPayment(String referenceNumber);

}
