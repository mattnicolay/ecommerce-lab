package com.solstice.accountaddress.controller;

import com.solstice.accountaddress.model.Account;
import com.solstice.accountaddress.model.Address;
import com.solstice.accountaddress.service.AccountService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping
  public ResponseEntity<List<Account>> getAccounts() {
    List<Account> accounts = accountService.getAccounts();
    return new ResponseEntity<>(
        accounts,
        new HttpHeaders(),
        accounts.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }

  @GetMapping("/{id}/address")
  public ResponseEntity<Address> getAddressByAccountId(@PathVariable("id") long id) {
    Address address = accountService.getAddressByAccountId();
    return new ResponseEntity<>(
        address,
        new HttpHeaders(),
        address == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }
}
