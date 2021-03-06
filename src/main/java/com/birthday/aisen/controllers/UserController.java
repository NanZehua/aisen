package com.birthday.aisen.controllers;

import com.birthday.aisen.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.birthday.aisen.dto.UserDTO;

@Controller
@RequestMapping("/api/user")
@CrossOrigin()
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "{uuid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserDTO> info(@PathVariable String uuid) {
        UserDTO info = userService.getUserById(uuid);
        return new ResponseEntity<UserDTO>(info, HttpStatus.OK);
    }
}
