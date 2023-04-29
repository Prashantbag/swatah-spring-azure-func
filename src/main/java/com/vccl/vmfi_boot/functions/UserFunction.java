package com.vccl.vmfi_boot.functions;

import com.vccl.vmfi_boot.domains.User;
import com.vccl.vmfi_boot.service.UserService;
import com.vccl.vmfi_boot.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class UserFunction {
    @Autowired
    UserService userService;

    @Bean("userSave")
    public Function<User, ResponseStructure> save() {
        return user -> userService.save(user);
    }

    @Bean("userUpdate")
    public Function<User, ResponseStructure> update() {
        return user -> userService.update(user);
    }

    @Bean("userGet")
    public Function<Integer, ResponseStructure> get() {
        return id -> userService.get(id);
    }

    @Bean("userDelete")
    public Function<Integer, ResponseStructure> delete() {
        return id -> userService.delete(id);
    }

    @Bean("userProfile")
    public Function<String, ResponseStructure> userProfile() {
        return id -> userService.userProfile(id);
    }
}
