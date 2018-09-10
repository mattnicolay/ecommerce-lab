package com.solstice.accountaddress.service;

import com.solstice.accountaddress.model.Account;
import com.solstice.accountaddress.model.Address;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AccountService {



  public List<Account> getAccounts() {
    return Arrays.asList(new Account());
  }

  public Address getAddressByAccountId() {
    return new Address();
  }
}
