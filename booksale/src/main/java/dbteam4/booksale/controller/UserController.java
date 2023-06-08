package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.LoginDTO;
import dbteam4.booksale.dto.RegisterDTO;
import dbteam4.booksale.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String save(@ModelAttribute RegisterDTO registerDTO) {
        userService.save(registerDTO);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpServletRequest request) {
        User loginUser = userService.login(loginDTO.getLoginID(), loginDTO.getPassword());

        if (loginUser == null) {
            return "login";
        }

        else {
            //로그인 성공 처리
            //세션이 있으면 세션 반환, 없으면 신규 세션 생성
            HttpSession session = request.getSession();
            //세션에 로그인 회원 정보 보관
            session.setAttribute(SessionConst.LOGIN_USER, loginUser);
            return "redirect:/";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
