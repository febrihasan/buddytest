package org.ait.project.buddytest.modules.account.service.internal.impl;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.account.dto.request.AccountRequestDto;
import org.ait.project.buddytest.modules.account.dto.response.AccountResponseDto;
import org.ait.project.buddytest.modules.account.model.entity.Account;
import org.ait.project.buddytest.modules.account.model.transform.AccountTransform;
import org.ait.project.buddytest.modules.account.service.delegate.AccountDelegate;
import org.ait.project.buddytest.modules.account.service.internal.AccountService;
import org.ait.project.buddytest.shared.constant.enums.ResponseEnum;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.ait.project.buddytest.shared.utils.ResponseHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**.
 * class Account Service Implements
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    /**.
     * Get function ResponseHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function AccountDelegate
     */
    private final AccountDelegate accountDelegate;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final AccountTransform accountTransform;

    /**.
     * Get all data accounts
     * @return all data accounts
     */
    public ResponseEntity<ResponseTemplate<ResponseList<AccountResponseDto>>>
    getAllAccounts() {
        List<Account> accounts = accountDelegate.getAllAccounts();
        return responseHelper
                .createResponseCollection(ResponseEnum.SUCCESS, null,
                accountTransform
                        .accountsToAccountsDto(accounts));
    }

    /**.
     * Get all data accounts with page
     * @param page number
     * @return all data accounts with pagination
     */
    public ResponseEntity<ResponseTemplate<ResponseList<AccountResponseDto>>>
    getAllAccountsWithPage(final Pageable page) {
        Page<Account> accountsWithPage = accountDelegate.getAllAccountsWithPage(page);
        return responseHelper
                .createResponseCollection(
                        ResponseEnum.SUCCESS,
                        accountsWithPage,
                accountTransform
                        .accountsToAccountsDto(
                                accountsWithPage.getContent()));
    }

    /**.
     * Get a data account
     * @param id account
     * @return data account
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    getAccountById(final Long id) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        accountTransform
                                .accountToAccountDto(accountDelegate.getAccountById(id)));
    }

    /**.
     * Create a new account
     * @param accountDto
     * @return new data account
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    createAccount(final AccountRequestDto accountDto) {
        Account account = accountTransform.accountDtoToAccount(accountDto);
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        accountTransform
                                .accountToAccountDto(accountDelegate.save(account)));
    }

    /**.
     * Update data account
     * @param id
     * @param accountDto
     * @return data account
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    updateAccount(final AccountRequestDto accountDto,
                                            final Long id) {
        Account account = accountTransform
                .updateAccountFromAccountDto(
                        accountDto,
                        accountDelegate
                                .getAccountById(id));
        account.setId(id);
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        accountTransform
                                .accountToAccountDto(accountDelegate.save(account)));
    }

    /**.
     * Update data account
     * @param accountDto
     * @param customerId
     * @return data account
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    updateBalance(final AccountRequestDto accountDto, final Long customerId) {

        Account account = accountDelegate
                .getAccountByAccountAndCustomerId(accountDto.getAccountNumber(), customerId);

        /*
         * Update available balance
         */
        accountDelegate.updateBalance(accountDto.getAvailableBalance(), accountDto.getAccountNumber(), customerId);

        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        accountTransform
                                .accountToAccountDto(accountDelegate
                                        .getAccountById(account.getId())));
    }

    /**.
     * Delete a data account
     * @param id account
     */
    public void deleteAccount(final Long id) {
        accountDelegate.deleteById(id);
    }

}
