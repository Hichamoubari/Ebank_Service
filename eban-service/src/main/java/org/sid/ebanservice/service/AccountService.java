package org.sid.ebanservice.service;

import org.sid.ebanservice.dto.BankAccountRequestDTO;
import org.sid.ebanservice.dto.BankAccountResponseDTO;
import org.sid.ebanservice.entities.BankAccount;
import org.sid.ebanservice.enums.AccountType;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
