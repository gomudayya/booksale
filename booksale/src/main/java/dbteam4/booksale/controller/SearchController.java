package dbteam4.booksale.controller;

import dbteam4.booksale.constant.BookSearchType;
import dbteam4.booksale.domain.Post;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final PostService postService;
    @GetMapping()
    public String search(@RequestParam("keyword") String keyword, @RequestParam("condition") String condition)
    {
        BookSearchCond bookSearchCond = new BookSearchCond(keyword, BookSearchType.valueOf(condition));

        List<Post> postList = postService.findPostList(bookSearchCond);


        for (var post : postList) {
            post.getBook();
        }


        System.out.println("postList = " + postList);


        return "search";
    }

    @GetMapping("/selected")
    public String selected() {return "selected";}
}