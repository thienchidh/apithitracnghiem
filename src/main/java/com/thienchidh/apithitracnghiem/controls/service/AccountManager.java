package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.controls.repo.AccountRepo;
import com.thienchidh.apithitracnghiem.model.entities.Account;
import com.thienchidh.apithitracnghiem.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountManager {
    private AccountRepo accountRepo;

    public User login(String clientUsername, String clientPassword) {
        var byUsername = accountRepo.findByUsername(clientUsername);
        if (byUsername.isPresent()) {
            var accountServer = byUsername.get();
            if (isPasswordCorrect(clientPassword, accountServer)) {
                return accountServer.getUser();
            }
        }
        return null;
    }

    private boolean isPasswordCorrect(String clientPassword, Account accountServer) {
        return accountServer.getPassword().equals(clientPassword);
    }

    public boolean isAccountValid(Account account) {
        return login(account.getUsername(), account.getPassword()) != null;
    }

}
