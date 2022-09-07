package org.ait.project.buddytest.modules.payment.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.payment.common.PathPaymentAPIs;
import org.ait.project.buddytest.modules.payment.dto.request.PaymentRequestDto;
import org.ait.project.buddytest.modules.payment.dto.response.PaymentResponseDto;
import org.ait.project.buddytest.modules.payment.service.internal.PaymentService;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**.
 * Class Rest Controller of Payment
 */
@RestController
@RequiredArgsConstructor
public class PaymentController {

    /**.
     *  Get function Payment Service
     */
    private final PaymentService paymentService;

    /**.
     *  Api for create payment
     * @param paymentDto
     */
    @Operation(summary = "Create new payment order",
            description = "Posting payment from order data and retrieve payment status")
    @PostMapping(PathPaymentAPIs.CREATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
        createPayment(final @RequestBody PaymentRequestDto paymentDto) {
        return paymentService.createPayment(paymentDto);
    }

    /**.
     *  Api for preview payment
     * @param referenceNumber
     */
    @Operation(summary = "Review payment", description = "Review payment")
    @GetMapping(PathPaymentAPIs.PREVIEW)
    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
        previewPayment(final @PathVariable String referenceNumber) {
        return paymentService.previewPayment(referenceNumber);
    }

    /**.
     *  Api for posting payment
     * @param referenceNumber
     */
    @Operation(summary = "Posting payment", description = "Posting payment")
    @PutMapping(PathPaymentAPIs.POSTING)
    public ResponseEntity<ResponseTemplate<ResponseDetail<PaymentResponseDto>>>
        postingPayment(final @PathVariable String referenceNumber) {
        return paymentService.postingPayment(referenceNumber);
    }

    /**.
     *  Api for Check status payment
     * @param referenceNumber
     */
    @Operation(summary = "Cancel payment", description = "Cancel payment")
    @DeleteMapping(PathPaymentAPIs.CANCEL)
    public void cancelPayment(final @PathVariable String referenceNumber) {
        paymentService.cancelPayment(referenceNumber);
    }

}