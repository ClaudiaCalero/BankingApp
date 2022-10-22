package com.IronhackLastProject.BankingApp.ControllerTest;

import com.IronhackLastProject.BankingApp.entities.DTOs.TransferDTO;
import com.IronhackLastProject.BankingApp.repositories.accounts.AccountRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import com.IronhackLastProject.BankingApp.services.users.AccountHolderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AccountHolderControllerTest {

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
       /* AccountHolder accountHolder = new AccountHolder("Clàudia", "1234",  LocalDate.of(1989, 3, 22),
                new Address("Calle de la Piruleta", "777", "País de la Gominola");
        accountHolderRepository.save(accountHolder);*/
    }

    @Test
    void transfer_money_OK() throws Exception {
        TransferDTO transferDTO = new TransferDTO("500", 1L , 2L);
        String body = objectMapper.writeValueAsString(transferDTO);
        MvcResult mvcResult = mockMvc.perform(patch("/transfer").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted()).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Sole"));
        assertEquals(500L, accountRepository.findById(1L).get().getBalance().getAmount().longValue());

    }
    @Test
    void transfer_money_not_enough_money() throws Exception {
        TransferDTO transferDTO = new TransferDTO("5000.00", 1L , 2L);
        String body = objectMapper.writeValueAsString(transferDTO);
        MvcResult mvcResult = mockMvc.perform(patch("/transfer").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertEquals("The account doesn't have enough funds", mvcResult.getResponse().getErrorMessage());

        assertEquals("The account doesn't have enough funds", mvcResult.getResponse().getErrorMessage());

    }

    @Test
    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();

    }
}



