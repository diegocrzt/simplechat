package py.una.pol.simplechat.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Diego Ramírez
 * @version 1.0
 * @since 1.0 2020/06/16
 */
@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void home() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Simple Chat Server"));
    }

    @Test
    void getMessagesFrom() throws Exception {
        mockMvc.perform(get("/messages/2020-06-16T21:40:34.087"))
                .andExpect(status().isOk());
    }

    @Test
    void acceptMessage() throws Exception {

        mockMvc.perform(post("/messages").contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"u\", \"content\": \"c\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/messages"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}