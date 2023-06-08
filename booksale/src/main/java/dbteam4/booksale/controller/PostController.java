package dbteam4.booksale.controller;

import dbteam4.booksale.constant.SessionConst;
import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.dto.PostDTO;
import dbteam4.booksale.service.BookApiService;
import dbteam4.booksale.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final BookApiService bookApiService;

    @GetMapping()
    public String post(@SessionAttribute(name = SessionConst.LOGIN_USER, required = true) User loginUser) {

        return "post";
    }

    @PostMapping()
    public String savePost(@ModelAttribute PostDTO postDTO) {

        System.out.println("postDTO = " + postDTO);

        postService.savePost(postDTO);
        bookApiService.saveBook(postDTO.getISBN());

        return "redirect:/";
    }

    @GetMapping("/view/{postId}")
    public String view(@PathVariable Long postId) {

        


        return "postview";
    }

    @GetMapping("/otherview")
    public String otherview(){return "postviewothers";}
}
