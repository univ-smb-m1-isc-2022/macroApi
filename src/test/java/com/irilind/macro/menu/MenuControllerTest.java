package com.irilind.macro.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MenuControllerTest {

    @Mock
    private MenuService menuService;

    @InjectMocks
    private MenuController menuController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void createMenuTest() throws Exception {
        // given
        Menu menu = Menu.builder().name("testMenu").build();
        when(menuService.createMenu(any(Menu.class))).thenReturn(menu);
        String requestBody = objectMapper.writeValueAsString(menu);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/menu")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // then
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseBody = response.getContentAsString();
        Assertions.assertTrue(responseBody.contains("\"id\":null"));
    }

    @Test
    void getAllMenuStartingWithTest() throws Exception {
        // given
        String startingChar = "a";
        List<Menu> menus = Arrays.asList(Menu.builder().name("apple").build(), Menu.builder().name("apricot").build());
        when(menuService.getAllMenuStartingWith(startingChar)).thenReturn(menus);

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/menu/startingWith")
                        .param("startingChar", startingChar)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // then
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseBody = response.getContentAsString();
        Assertions.assertTrue(responseBody.contains("apple"));
        Assertions.assertTrue(responseBody.contains("apricot"));
    }
}