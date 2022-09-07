package org.ait.project.buddytest.modules.account.service.internal;

import org.ait.project.buddytest.modules.account.dto.request.AccountRequestDto;
import org.ait.project.buddytest.modules.account.dto.response.AccountResponseDto;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**.
 * Interface Inventory Service
 */
public interface AccountService {

    public ResponseEntity<ResponseTemplate<ResponseList<AccountResponseDto>>>
    getAllAccounts();

    public ResponseEntity<ResponseTemplate<ResponseList<AccountResponseDto>>>
    getAllAccountsWithPage(Pageable page);

    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    getAccountById(Long id);

    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    createAccount(AccountRequestDto accountDto);

    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    updateAccount(AccountRequestDto accountDto, Long id);

    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    updateBalance(AccountRequestDto accountDto, Long customerId);

    public void deleteAccount(Long id);

}
