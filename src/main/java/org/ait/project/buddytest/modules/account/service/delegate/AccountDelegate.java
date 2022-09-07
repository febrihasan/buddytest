package org.ait.project.buddytest.modules.account.service.delegate;

import java.math.BigDecimal;
import java.util.List;
import org.ait.project.buddytest.modules.account.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountDelegate {

  List<Account> getAllAccounts();

  Page<Account> getAllAccountsWithPage(Pageable page);

  Account getAccountById(Long id);

  Account getAccountByAccountAndCustomerId(String accountNumber, Long customerId);

  void updateBalance(BigDecimal remaining, String accountNumber, Long customerId);

  List<Account> saveAll(List<Account> accounts);

  Account save(Account inventory);

  void deleteById(Long id);

}
