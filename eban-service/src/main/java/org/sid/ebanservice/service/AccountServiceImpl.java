package org.sid.ebanservice.service;

import org.sid.ebanservice.Repositories.BankAccountRepository;
import org.sid.ebanservice.dto.BankAccountRequestDTO;
import org.sid.ebanservice.dto.BankAccountResponseDTO;
import org.sid.ebanservice.entities.BankAccount;
import org.sid.ebanservice.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        /*BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();*/
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountDTO);

        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

       BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountResponseDTO;
    }
}
