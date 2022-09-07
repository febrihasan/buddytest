package org.ait.project.buddytest.modules.payment.service.delegate;

import org.ait.project.buddytest.modules.payment.model.entity.Payment;

public interface PaymentDelegate {

  Payment save(Payment payment);

  Payment getPaymentByReferenceNumber(String referenceNumber);

  void updateStatusByReferenceNumber(String status, String referenceNumber);

}
