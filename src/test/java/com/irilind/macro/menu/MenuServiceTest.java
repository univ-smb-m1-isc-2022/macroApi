package com.irilind.macro.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class MenuServiceTest {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuService menuService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createMenuTest() {
        // given
        Menu menu = Menu.builder().name("testMenu").build();
        when(menuRepository.save(menu)).thenReturn(menu);

        // when
        Menu result = menuService.createMenu(menu);

        // then
        Assertions.assertEquals(menu, result);
    }

    @Test
    void getAllMenuStartingWithTest() {
        // given
        String startingChar = "a";
        List<Menu> menus = Arrays.asList(Menu.builder().name("apple").build(), Menu.builder().name("apricot").build());
        PageRequest pageRequest = PageRequest.of(0, 10);
        when(menuRepository.findAllByNameStartingWith(anyString(), any(PageRequest.class))).thenReturn(menus);

        // when
        List<Menu> result = menuService.getAllMenuStartingWith(startingChar);

        // then
        Assertions.assertEquals(menus, result);
    }
}