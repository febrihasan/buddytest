package org.ait.project.buddytest.modules.payment.service.internal.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.payment.common.ResponseStatus;
import org.ait.project.buddytest.modules.payment.dto.request.PaymentRequestDto;
import org.ait.project.buddytest.modules.payment.dto.response.PaymentResponseDto;
import org.ait.project.buddytest.modules.payment.model.entity.Payment;
import org.ait.project.buddytest.modules.payment.model.transform.PaymentClientTransform;
import org.ait.project.buddytest.modules.payment.model.transform.PaymentTransform;
import org.ait.project.buddytest.modules.payment.service.delegate.PaymentDelegate;
import org.ait.project.buddytest.modules.payment.service.internal.PaymentService;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.openfeign.payment.PaymentClient;
import org.ait.project.buddytest.shared.openfeign.payment.response.PostingPaymentResponse;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**.
 * class Product Service Implements
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    /**.
     * Get function ResponseHelper
     */
    private final ResponseHelper responseHelper;

    private final PaymentClient paymentClient;

    /**.
     * Get function ProductDelegate
     */
    private final PaymentDelegate paymentDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final PaymentTransform paymentTransform;

    /**.
     * Create a payment
     * @param paymentDto
     * @return data payment
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
    createPayment(final PaymentRequestDto paymentDto) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");

        Payment payment = paymentTransform.paymentDtoToPayment(paymentDto);
        payment.setReferenceNumber("FT" + sdf.format(new Date()));
        payment.setStatus(ResponseStatus.PENDING.toString());
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        paymentTransform.paymentToPaymentDto(paymentDelegate.save(payment)));
    }

    /**.
     * Preview or check status payment
     * @param referenceNumber
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
    previewPayment(final String referenceNumber) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        paymentTransform.paymentToPaymentDto(paymentDelegate
                                .getPaymentByReferenceNumber(referenceNumber)));
    }

    /**.
     * Posting payment and integrating with open feign
     * @param referenceNumber
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
    postingPayment(final String referenceNumber) {

        Payment payment = paymentDelegate
                .getPaymentByReferenceNumber(referenceNumber);

        String statusPayment = "";
        if (payment.getStatus().equals(ResponseStatus.PENDING)) {
            PostingPaymentResponse paymentResponse = paymentClient
                    .postingPayment(PaymentClientTransform.convert(payment));

            if (paymentResponse.getStatus().equals(ResponseStatus.SUCCESS)) {
                statusPayment = ResponseStatus.SUCCESS.toString();
            } else {
                statusPayment = ResponseStatus.CANCEL.toString();
            }
        }

        paymentDelegate.updateStatusByReferenceNumber(statusPayment, referenceNumber);

        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        paymentTransform.paymentToPaymentDto(payment));
    }

    /**.
     * Cancel a payment
     * @param referenceNumber
     */
    public void cancelPayment(final String referenceNumber) {
        paymentDelegate
                .updateStatusByReferenceNumber(ResponseStatus.CANCEL.toString(), referenceNumber);
    }

}