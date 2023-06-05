package dbteam4.booksale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    @GetMapping()
    public String post(){return "post";}

    @GetMapping("/view")
    public String view(){return "postview";}

    @GetMapping("/otherview")
    public String otherview(){return "postviewothers";}
}
