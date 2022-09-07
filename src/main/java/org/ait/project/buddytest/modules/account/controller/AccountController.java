package org.ait.project.buddytest.modules.account.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.ait.project.buddytest.modules.account.common.PathAccountAPIs;
import org.ait.project.buddytest.modules.account.dto.request.AccountRequestDto;
import org.ait.project.buddytest.modules.account.dto.response.AccountResponseDto;
import org.ait.project.buddytest.modules.account.service.internal.AccountService;
import org.ait.project.buddytest.shared.dto.template.ResponseDetail;
import org.ait.project.buddytest.shared.dto.template.ResponseList;
import org.ait.project.buddytest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**.
 * Class Rest Controller of Account
 */
@RestController
@RequiredArgsConstructor
public class AccountController {

    /**.
     *  Get function Account Service
     */
    private final AccountService accountService;

    /**.
     *  Api for Get all accounts
     */
    @Operation(summary = "Get all accounts",
            description = "Retrieve a list of all acounts")
    @GetMapping(PathAccountAPIs.FIND_ALL)
    public ResponseEntity<ResponseTemplate<ResponseList<AccountResponseDto>>>
        getAllAccounts() {
        return accountService.getAllAccounts();
    }

    /**.
     *  Api for Get all accounts with pagination
     * @param page number
     */
    @Operation(summary = "Get all accounts by page",
            description = "Retrieves a list of all accounts with pagination")
    @GetMapping(PathAccountAPIs.FIND_ALL_WITH_PAGE)
    public ResponseEntity<ResponseTemplate<ResponseList<AccountResponseDto>>>
        getAllAccountsWithPage(final Pageable page) {
        return accountService.getAllAccountsWithPage(page);
    }

    /**.
     *  Api for Get a account
     * @param id
     * @return data account
     */
    @Operation(summary = "Get account by id",
            description = "Retrieves a spesific account by id")
    @GetMapping(PathAccountAPIs.FIND_ONE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
        getAccountById(final @PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    /**.
     *  Api for Create a new account
     * @param accountDto
     * @return new data account
     */
    @Operation(summary = "Create new account",
            description = "Create a new account")
    @PostMapping(PathAccountAPIs.CREATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
        createAccount(final @RequestBody AccountRequestDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    /**.
     *  Api for Update a account
     * @param id
     * @param accountDto
     * @return data account
     */
    @Operation(summary = "Update account",
            description = "Update a account")
    @PutMapping(PathAccountAPIs.UPDATE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
        updateAccount(final @RequestBody AccountRequestDto accountDto,
                                            final @PathVariable Long id) {
        return accountService.updateAccount(accountDto, id);
    }

    /**.
     *  Api for Update available balance
     * @param accountDto
     * @param customerId
     * @return data account
     */
    @Operation(summary = "Update available balance by customerId",
            description = "Update available balance by customerId")
    @PutMapping(PathAccountAPIs.UPDATE_BALANCE)
    public ResponseEntity<ResponseTemplate<ResponseDetail<AccountResponseDto>>>
    updateBalance(final @RequestBody AccountRequestDto accountDto,
                  final @PathVariable Long customerId) {
        return accountService.updateBalance(accountDto, customerId);
    }

    /**.
     *  Api for Delete a account
     * @param id
     */
    @Operation(summary = "Delete account",
            description = "Delete a account")
    @DeleteMapping(PathAccountAPIs.DELETE)
    public void deleteAccount(final @PathVariable Long id) {
        accountService.deleteAccount(id);
    }

}