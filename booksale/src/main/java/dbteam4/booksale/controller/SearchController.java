package dbteam4.booksale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {
    @GetMapping()
    public String search(){return "search";}

    @GetMapping("/selected")
    public String selected() {return "selected";}
}