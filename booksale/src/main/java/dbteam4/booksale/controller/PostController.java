package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.dto.PostDTO;
import dbteam4.booksale.service.BookApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final BookApiService bookApiService;

    @GetMapping()
    @CrossOrigin
//    public String post(@SessionAttribute(name = SessionConst.LOGIN_USER, required = true) User loginUser) {
    public String post() {

        return "post";
    }

    @PostMapping()
    public String savePost(@RequestParam("ISBN") String ISBN) {
        bookApiService.saveBook(ISBN);

        return "redirect:/";
    }

    @GetMapping("/view/{postId}")
    public String view(@PathVariable Long postId) {

        


        return "postview";
    }

    @GetMapping("/otherview")
    public String otherview(){return "postviewothers";}
}
