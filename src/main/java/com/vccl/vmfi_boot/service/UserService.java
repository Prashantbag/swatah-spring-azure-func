package com.vccl.vmfi_boot.service;

import com.vccl.vmfi_boot.domains.User;
import com.vccl.vmfi_boot.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setId(1);
        user.setName("Piyush Jain");
        user.setEmail("piyush@gmail.com");
        users.add(user);
    }

    public ResponseStructure save(User user) {
        users.add(user);
        ResponseStructure responseDTO = new ResponseStructure();

        responseDTO.setMessage("Success");
        responseDTO.setData(user);
        return responseDTO;
    }

    public ResponseStructure update(User user) {
        ResponseStructure responseDTO = new ResponseStructure();
        if (user.getId() != null) {
            users.removeIf(it -> it.getId() == user.getId());
            users.add(user);
            responseDTO.setData(user);
            responseDTO.setStatus(true);
            responseDTO.setMessage("Record Update Successfully ");
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseStructure get(Integer id) {
        ResponseStructure responseDTO = new ResponseStructure();
        if (id != null) {
            User user = users.stream().filter(it -> it.getId() == id).findFirst().get();
            responseDTO.setData(user);
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseStructure delete(Integer id) {
        ResponseStructure responseDTO = new ResponseStructure();
        if (id != null) {
            users.removeIf(it -> it.getId() == id);
            responseDTO.setMessage("Record is deleted successfully");
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseStructure getAll() {
        ResponseStructure responseDTO = new ResponseStructure();
        responseDTO.setData(users);
        return responseDTO;
    }

    public ResponseStructure userProfile(String id) {
        User user = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id, User.class).getBody();
        ResponseStructure responseDTO = new ResponseStructure();
        responseDTO.setData(user);
        return responseDTO;
    }
}
