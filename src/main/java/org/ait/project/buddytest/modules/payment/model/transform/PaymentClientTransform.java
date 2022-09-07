package org.ait.project.buddytest.modules.payment.model.transform;

import org.ait.project.buddytest.modules.payment.model.entity.Payment;
import org.ait.project.buddytest.shared.openfeign.payment.request.PostingPaymentRequest;

public class PaymentClientTransform {

    public static PostingPaymentRequest convert(final Payment payment) {
        PostingPaymentRequest paymentRequest = new PostingPaymentRequest();
        paymentRequest.setReferenceNumber(payment.getReferenceNumber());
        paymentRequest.setSourceAccount(payment.getSourceAccount());
        paymentRequest.setSenderName(payment.getSenderName());
        paymentRequest.setSenderBankCode(payment.getSenderBankCode());
        paymentRequest.setReceiverBankName(payment.getSenderBankName());
        paymentRequest.setTargetAccount(payment.getTargetAccount());
        paymentRequest.setReceiverName(payment.getReceiverName());
        paymentRequest.setReceiverBankCode(payment.getReceiverBankCode());
        paymentRequest.setReceiverBankName(payment.getReceiverBankName());
        paymentRequest.setAmount(payment.getAmount());
        return paymentRequest;
    }

}
