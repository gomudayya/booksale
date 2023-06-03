package dbteam4.booksale.controller;

import dbteam4.booksale.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public String register() { return "register"; }

    @GetMapping("/login")
    public String login() { return "login";}

    @PostMapping("/save")
    public String save(@ModelAttribute UserDTO userDTO) {
        log.info("userDTO ={}", userDTO.toString());
        return null;
    }
}
