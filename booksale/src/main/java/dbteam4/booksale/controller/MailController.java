package dbteam4.booksale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {
    @GetMapping()
    public String mail(){return "mail";}

    @GetMapping("/maileach")
    public String eachmail(){return "maileach";}
}
