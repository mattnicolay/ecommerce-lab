package com.solstice.accountaddress.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.solstice.accountaddress.model.Account;
import com.solstice.accountaddress.model.Address;
import com.solstice.accountaddress.service.AccountService;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerUnitTest {

  private Logger logger = LoggerFactory.getLogger(AccountControllerUnitTest.class);

  @Mock
  private AccountService accountService;

  @InjectMocks
  private AccountController accountController;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
  }

  @Test
  public void accountsEndpointSuccessTest() {
    when(accountService.getAccounts()).thenReturn(Arrays.asList(new Account()));
    mockMvcPerformGet("/accounts", 200);
  }

  @Test
  public void accountEndpointFailureTest() {
    mockMvcPerformGet("/accounts", 404);
  }

  @Test
  public void addressEndpointSuccessTest() {
    when(accountService.getAddressByAccountId()).thenReturn(new Address());
    mockMvcPerformGet("/accounts/1/address", 200);
  }

  @Test
  public void addressEndpointFailureTest() {
    mockMvcPerformGet("/accounts/1/address", 404);
  }

  private void mockMvcPerformGet(String endpoint, int expectedStatus) {
    try {
      mockMvc.perform(get(endpoint)).andExpect(status().is(expectedStatus));
    } catch (Exception e) {
      logger.error("Exception thrown: {}", e.toString());
    }
  }
}
