package be.heh.adapter;


import be.heh.adapter.in.web.AdaptateurUserController;
import be.heh.application.domain.model.User;
import be.heh.application.domain.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



public class AdaptateurUserControlleurTest {

        @Test
        public void testGetUserById() throws Exception {

            int userId = 1;
            User userTest = new User(userId, "maxime", "maxime.willem@std.be", "Test123*");

            // userServiceMock
            UserService userServiceMock = Mockito.mock(UserService.class);
            Mockito.when(userServiceMock.getUserById(Mockito.anyInt())).thenReturn(userTest);

            AdaptateurUserController userController = new AdaptateurUserController(userServiceMock);

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

            mockMvc.perform(get("/users/{userId}", userId))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").exists())
                    .andExpect(jsonPath("$.id").value(userId))
                    .andExpect(jsonPath("$.username").value("maxime"))
                    .andExpect(jsonPath("$.email").value("maxime.willem@std.be"))
                    .andExpect(jsonPath("$.password").value("Test123*"));


        }

    }




