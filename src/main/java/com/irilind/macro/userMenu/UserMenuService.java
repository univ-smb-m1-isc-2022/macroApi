package com.irilind.macro.userMenu;

import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class UserMenuService {

    UserMenuRepository repository;

    public UserMenuService(UserMenuRepository repository) {
        this.repository = repository;
    }

    public List<UserMenu> getAllUserMenu() {
        return repository.findAll();
    }

    public  List<UserMenu> getAllUserMenuByUserId(Integer id) {
        return repository.findAllByUserId(id);
    }

    public UserMenu createUserMenu(UserMenu userMenu) {
        return repository.save(userMenu);
    }

}
