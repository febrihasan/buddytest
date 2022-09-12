package org.ait.project.buddytest.modules.payment.service.internal.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.openfeign.payment.PaymentClient;
import org.ait.project.buddytest.shared.openfeign.payment.response.PostingPaymentResponse;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**.
 * class Product Service Implements
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LogManager.getLogger(PaymentServiceImpl.class);

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
     * Get all data customers
     * @return all data customers
     */
    public ResponseEntity<ResponseTemplate<ResponseList<PaymentResponseDto>>>
    getAllPayments() {
        List<Payment> payments = paymentDelegate.getAllPayments();
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                paymentTransform.paymentListToPaymentDtoList(payments));
    }

    /**.
     * Get all data customers with page
     * @param page number
     * @return all data customers with pagination
     */
    public ResponseEntity<ResponseTemplate<ResponseList<PaymentResponseDto>>>
    getAllPaymentsWithPage(final Pageable page) {
        Page<Payment> paymentsWithPage = paymentDelegate
                .getAllPaymentsWithPage(page);
        return responseHelper
                .createResponseCollection(
                        ResponseEnum.SUCCESS,
                        paymentsWithPage,
                        paymentTransform
                                .paymentListToPaymentDtoList(
                                        paymentsWithPage.getContent()));
    }

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
        payment.setStatus(ResponseStatus.PROCESSED.toString());
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

        String paymentResponse = paymentClient
                .previewPayment(referenceNumber);

        /*
         * Convert from response to map
         */
        Map<String, Object> mapper = convert(paymentResponse);

        Payment payment = null;
        if (!mapper.get("status").toString().isEmpty()) {
            payment = paymentDelegate
                    .getPaymentByReferenceNumber(referenceNumber);
        }

        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        paymentTransform.paymentToPaymentDto(payment));
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
        if (payment.getStatus()
                .equals(ResponseStatus.PROCESSED.toString())) {
            String paymentResponse = paymentClient
                    .postingPayment(PaymentClientTransform.convert(payment));

            /*
             * Convert from response to map
             */
            Map<String, Object> mapper = convert(paymentResponse);

            if (mapper.get("status").toString()
                    .equals(ResponseStatus.FAILED.toString())) {
                payment.setStatus(ResponseStatus.CANCELLED.toString());
                statusPayment = ResponseStatus.CANCELLED.toString();
            } else {
                payment.setStatus(ResponseStatus.SUCCEED.toString());
                statusPayment = ResponseStatus.SUCCEED.toString();
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
        String paymentResponse = paymentClient
                .cancelPayment(referenceNumber);

        /*
         * Convert from response to map
         */
        Map<String, Object> mapper = convert(paymentResponse);

        if (mapper.get("status").toString()
                .equals(ResponseStatus.FAILED.toString())) {
            paymentDelegate
                    .updateStatusByReferenceNumber(ResponseStatus.CANCELLED.toString(), referenceNumber);
        }
    }

    private Map<String, Object> convert(final String response) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        try {
            map = mapper.readValue(response, Map.class);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        return map;
    }

}
