package dbteam4.booksale.controller;

import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.service.BookApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final BookApiService bookApiService;

    @GetMapping()
    public String post(){return "post";}

    @PostMapping()
    public String savePost(@RequestParam("ISBN") String ISBN) {
        bookApiService.saveBook(ISBN);
        

        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(){return "postview";}

    @GetMapping("/otherview")
    public String otherview(){return "postviewothers";}


}
