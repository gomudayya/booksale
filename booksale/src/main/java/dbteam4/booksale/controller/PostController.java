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
    public String post(@SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser) {

        return "post";
    }

    @PostMapping()
    public String savePost(@ModelAttribute PostDTO postDTO, @SessionAttribute(name = SessionConst.LOGIN_USER) User loginUser) {
        postDTO.setSellerId(loginUser.getId());
        postDTO.setPostTime(LocalDateTime.now());

        System.out.println("postDTO = " + postDTO);

        //무조건 책 먼저 저장해야함
        bookApiService.saveBook(postDTO.getISBN());
        postService.savePost(postDTO);

        return "redirect:/";
    }

    @GetMapping("/view/{postId}")
    public String view(@PathVariable Long postId) {

        


        return "postview";
    }

    @GetMapping("/otherview")
    public String otherview(){return "postviewothers";}
}
