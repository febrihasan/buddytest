package org.ait.project.buddytest.modules.account.model.transform;

import java.util.List;
import org.ait.project.buddytest.modules.account.dto.request.AccountRequestDto;
import org.ait.project.buddytest.modules.account.dto.response.AccountResponseDto;
import org.ait.project.buddytest.modules.account.model.entity.Account;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountTransform {
    Account accountDtoToAccount(AccountRequestDto accountDto);

    AccountResponseDto accountToAccountDto(Account account);

    List<AccountResponseDto> accountsToAccountsDto(List<Account> account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account updateAccountFromAccountDto(AccountRequestDto accountDto, @MappingTarget Account account);
}
