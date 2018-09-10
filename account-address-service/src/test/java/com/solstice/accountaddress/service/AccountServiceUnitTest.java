package com.solstice.accountaddress.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import com.solstice.accountaddress.model.Account;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class AccountServiceUnitTest {

  private AccountService accountService;

  @Test
  public void getAccountsNotEmptyTest() {
    List<Account> accounts = accountService.getAccounts();

    assertThat(accounts, is(notNullValue()));
    assertFalse(accounts.isEmpty());
  }

  @Test
  public void getAccountsReturnedListHasValuesTest() {
    List<Account> accounts = accountService.getAccounts();

    assertThat(accounts, is(notNullValue()));
    assertFalse(accounts.isEmpty());
    accounts.forEach(account -> {
      assertThat(account, is(notNullValue()));
      assertThat(account.getFirstName(), is(notNullValue()));
      assertThat(account.getLastName(), is(notNullValue()));
      assertThat(account.getEmail(), is(notNullValue()));
      assertThat(account.getAddresses(), is(notNullValue()));
    });
  }
}
