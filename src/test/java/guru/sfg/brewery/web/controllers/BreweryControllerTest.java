package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BreweryControllerTest extends BaseIT{

    @Test
    void listBreweriesCustomerRole() throws Exception {
        mockMvc.perform(get("/brewery/breweries")
                .with(httpBasic("scott", "password")))
                .andExpect(status().is2xxSuccessful());

        mockMvc.perform(get("/brewery/api/v1/breweries")
                .with(httpBasic("scott", "password")))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void listBreweriesAdminRole() throws Exception {
        mockMvc.perform(get("/brewery/breweries")
                .with(httpBasic("spring", "password")))
                .andExpect(status().is2xxSuccessful());

        mockMvc.perform(get("/brewery/api/v1/breweries")
                .with(httpBasic("spring", "password")))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void listBreweriesUserRole() throws Exception {
        mockMvc.perform(get("/brewery/breweries")
                .with(httpBasic("user", "password")))
                .andExpect(status().isForbidden());

        mockMvc.perform(get("/brewery/api/v1/breweries")
                .with(httpBasic("user", "password")))
                .andExpect(status().isForbidden());
    }
}