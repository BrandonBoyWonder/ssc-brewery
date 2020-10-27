package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BeerRestIT  extends BaseIT{

    @Test
    void deleteBeerUrl() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/5fb7e46-932d-4ab8-a903-b0131fe03686")
                .param("Api-key", "spring").param("Api-Secert", "guru"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteBeerBadCreds() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/5fb7e46-932d-4ab8-a903-b0131fe03686")
                .header("Api-key", "spring").header("Api-Secert", "guruXXXX"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void deleteBeer() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/5fb7e46-932d-4ab8-a903-b0131fe03686")
        .header("Api-key", "spring").header("Api-Secert", "guru"))
        .andExpect(status().isOk());
    }

    @Test
    void findBeers() throws Exception {
        mockMvc.perform(get("/api/v1/beer/"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/5fb7e46-932d-4ab8-a903-b0131fe03686"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeerByUp() throws Exception{
        mockMvc.perform(get("/api/v1/beerUpc/0631234200036"))
                .andExpect(status().isOk());
    }
}
