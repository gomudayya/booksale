package dbteam4.booksale.controller;

import dbteam4.booksale.dto.UserDTO;
import dbteam4.booksale.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register() { return "register"; }

    @GetMapping("/login")
    public String login() { return "login";}

    @PostMapping("/save")
    public String save(@ModelAttribute UserDTO userDTO) {
        log.info("userDTO ={}", userDTO.toString());
        userService.save(userDTO);
        return "redirect:/";
    }
}
