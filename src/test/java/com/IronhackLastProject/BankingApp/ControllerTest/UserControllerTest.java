package com.IronhackLastProject.BankingApp.ControllerTest;

import com.IronhackLastProject.BankingApp.entities.users.Admin;
import com.IronhackLastProject.BankingApp.entities.users.ThirdParty;
import com.IronhackLastProject.BankingApp.repositories.users.AccountHolderRepository;
import com.IronhackLastProject.BankingApp.repositories.users.AdminRepository;
import com.IronhackLastProject.BankingApp.repositories.users.UserRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
class UserControllerTest {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void UserShouldCreateAdmin_Created() throws Exception {
        Admin admin = new Admin("Holi", "1234", "holi");

        String body = objectMapper.writeValueAsString(admin);
        MvcResult mvcResult = mockMvc.perform(post("/admin").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Holi"));
    }

   /* @Test
    void UserShouldCreateAccountHolder_Created() throws Exception {

        Address address = new Address("Del Valles", "12345", "desi@hola");
        AccountHolder accountHolder = new AccountHolder("Des", "1234567", LocalDate.of(1996, 2, 22), address, "Desi", address);
        String body = objectMapper.writeValueAsString(accountHolder);
        MvcResult mvcResult = mockMvc.perform(post("/accountHolder").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Des"));
    }*/

    @Test
    void UserShouldCreateThirdParty_Created() throws Exception {
        ThirdParty thirdParty = new ThirdParty("Nurs", "12345", "12345678", "Nuria");

        String body = objectMapper.writeValueAsString(thirdParty);
        MvcResult mvcResult = mockMvc.perform(post("/thirdParty").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Nurs"));
    }
}

