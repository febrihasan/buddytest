package org.ait.project.buddytest.modules.payment.service.delegate.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.payment.model.entity.Payment;
import org.ait.project.buddytest.modules.payment.model.repository.PaymentRepository;
import org.ait.project.buddytest.modules.payment.service.delegate.PaymentDelegate;
import org.springframework.stereotype.Service;

/**.
 * Class Payment Delegate Implements
 */
@Service
@RequiredArgsConstructor
public class PaymentDelegateImpl implements PaymentDelegate {

  private final PaymentRepository repository;

  @Override
  public Payment save(final Payment payment) {
    return repository.save(payment);
  }

  @Override
  public Payment getPaymentByReferenceNumber(final String referenceNumber) {
    return repository.getPaymentByReferenceNumber(referenceNumber);
  }

  @Override
  public void updateStatusByReferenceNumber(final String status, final String referenceNumber) {
    repository.updateStatusByReferenceNumber(status, referenceNumber);
  }

}
