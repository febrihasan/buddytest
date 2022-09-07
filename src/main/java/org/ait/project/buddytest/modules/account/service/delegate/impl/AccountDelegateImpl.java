package org.ait.project.buddytest.modules.account.service.delegate.impl;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.account.exception.JPHAccountNotFoundException;
import org.ait.project.buddytest.modules.account.model.entity.Account;
import org.ait.project.buddytest.modules.account.model.repository.AccountRepository;
import org.ait.project.buddytest.modules.account.service.delegate.AccountDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**.
 * Class Account Delegate Implements
 */
@Service
@RequiredArgsConstructor
public class AccountDelegateImpl implements AccountDelegate {

  private final AccountRepository repository;

  public List<Account> getAllAccounts() {
    return repository.findAll();
  }

  @Override
  public Page<Account> getAllAccountsWithPage(final Pageable page) {
    return repository.findAll(page);
  }

  @Override
  public Account getAccountById(final Long id) {
    return repository.findById(id).orElseThrow(JPHAccountNotFoundException::new);
  }

  @Override
  public Account getAccountByAccountAndCustomerId(final String accountNumber, final Long customerId) {
    return repository.findByAccountAndCustomerId(accountNumber, customerId);
  }

  @Override
  public void updateBalance(final BigDecimal remaining, final String accountNumber, final Long customerId) {
    repository.updateBalance(remaining, accountNumber, customerId);
  }

  @Override
  public List<Account> saveAll(final List<Account> accountList) {
    return repository.saveAll(accountList);
  }

  @Override
  public Account save(final Account account) {
    return repository.save(account);
  }

  @Override
  public void deleteById(final Long id) {
    repository.deleteById(id);
  }

}
