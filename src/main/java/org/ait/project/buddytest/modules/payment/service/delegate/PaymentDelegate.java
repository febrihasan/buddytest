package org.ait.project.buddytest.modules.payment.service.delegate;

import java.util.List;
import org.ait.project.buddytest.modules.payment.model.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentDelegate {

  List<Payment> getAllPayments();

  Page<Payment> getAllPaymentsWithPage(Pageable page);

  Payment save(Payment payment);

  Payment getPaymentByReferenceNumber(String referenceNumber);

  void updateStatusByReferenceNumber(String status, String referenceNumber);

}
