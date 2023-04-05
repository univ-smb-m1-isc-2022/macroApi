package com.irilind.macro.userMenu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMenuRepository extends JpaRepository<UserMenu, Integer> {

    List<UserMenu> findAllByUserId(Integer id);
}
