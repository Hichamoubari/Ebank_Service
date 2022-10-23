package org.sid.ebanservice;

import org.sid.ebanservice.Repositories.BankAccountRepository;
import org.sid.ebanservice.entities.BankAccount;
import org.sid.ebanservice.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbanServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for(int i=0;i<10;i++){
				BankAccount bankAccount = BankAccount.builder().id(UUID.randomUUID().toString()).type(Math.random()>0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()*90000).createAt(new Date())
						.currency("MAD").build();
				bankAccountRepository.save(bankAccount);
			}
		};
	}

}
