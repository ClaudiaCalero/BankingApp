package com.IronhackLastProject.BankingApp.ControllerTest;

import com.IronhackLastProject.BankingApp.entities.DTOs.AccountDTO;
import com.IronhackLastProject.BankingApp.repositories.accounts.AccountRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AccountControllerTest {
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void getAccountsIdReturnThisId_OK() throws Exception {
        long accountId = 1L;
        String body = objectMapper.writeValueAsString(accountId);
        MvcResult mvcResult = mockMvc.perform(get("/accounts/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Owner"));
    }

    @Test
    void AccountShouldCreateCheckingAccounts_Created() throws Exception {
        AccountDTO accountDTO = new AccountDTO("1000", "50", 1L, 2L, "0.0025", "100");

        String body = objectMapper.writeValueAsString(accountDTO);
        MvcResult mvcResult = mockMvc.perform(post("/createChecking").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("50"));
    }

    @Test
    void AccountShouldCreateSavingsAccounts_Created() throws Exception {
        AccountDTO accountDTO = new AccountDTO("1000", "50", 1L, 2L, "0.0025", "100");

        String body = objectMapper.writeValueAsString(accountDTO);
        MvcResult mvcResult = mockMvc.perform(post("/createSavings").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("0.0025"));

    }
    @Test
    void AccountShouldCreateCreditCard_Created() throws Exception {
        AccountDTO accountDTO = new AccountDTO("1000", "50", 1L, 2L, "0.0025", "100");

        String body = objectMapper.writeValueAsString(accountDTO);
        MvcResult mvcResult = mockMvc.perform(post("/createCreditCard").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("100"));

    }

}

