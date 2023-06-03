package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.repository.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserMapper userMapper;
    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "index";
        }

        User loginUser = (User) session.getAttribute(SessionConst.LOGIN_USER);

        //세션에 회원 데이터가 없으면 home
        if(loginUser == null) {
            return "index";
        }

        //세션이 확인되면 로그인으로 이동
        model.addAttribute("user", loginUser);
        return "loginIndex";
    }
}
