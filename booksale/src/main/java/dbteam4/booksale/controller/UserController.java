package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.LoginDTO;
import dbteam4.booksale.dto.RegisterDTO;
import dbteam4.booksale.repository.UserMapper;
import dbteam4.booksale.service.SchoolService;
import dbteam4.booksale.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SchoolService schoolService;
    private final UserService userService;
    private final UserMapper userMapper;



    @GetMapping("/register")
    public String register(Model model) {
        HashMap<String, List<String>> allSchoolByMap = schoolService.findAllSchoolByMap();
        model.addAttribute("schoolMajorMap", allSchoolByMap);
        return "user/register";
    }

    @GetMapping("/login")
    public String login() { return "user/login";}

    @GetMapping("/info")
    public String userInfo(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User loginUser, Model model) {
        model.addAttribute("user", loginUser);
        return "user/userInfo";
    }

    @GetMapping("/edit")
    public String userEdit(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User loginUser, Model model) {
        model.addAttribute("user", loginUser);
        return "user/userEdit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute RegisterDTO registerDTO) {
        userService.save(registerDTO);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpServletRequest request) {
        User loginUser = userService.login(loginDTO.getLoginID(), loginDTO.getPassword());


        if (loginUser == null) {
            return "user/login";
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
        String referer = request.getHeader("Referer");

        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:" + referer;
    }

    @PostMapping("/edit")
    public String userEdit(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User loginUser,
                           @ModelAttribute RegisterDTO registerDTO){

        User user = loginUser;

        userService.update(user, registerDTO);

        return "redirect:/user/info";
    }
}
