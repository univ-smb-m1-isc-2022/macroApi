package com.irilind.macro.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @Test
    void testMenuBuilder() {
        // given
        String name = "testMenu";

        // when
        Menu menu = Menu.builder().name(name).build();

        // then
        Assertions.assertEquals(name, menu.getName());
    }

    @Test
    void testMenuEquals() {
        // given
        Menu menu1 = Menu.builder().id(1).name("testMenu").build();
        Menu menu2 = Menu.builder().id(1).name("testMenu").build();
        Menu menu3 = Menu.builder().id(2).name("testMenu").build();

        // then
        Assertions.assertEquals(menu1, menu2);
        Assertions.assertNotEquals(menu1, menu3);
        Assertions.assertNotEquals(menu2, menu3);
    }
}