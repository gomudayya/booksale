package dbteam4.booksale.controller;

import dbteam4.booksale.constant.BookSearchType;
import dbteam4.booksale.dto.BookPostsDTO;
import dbteam4.booksale.dto.BookSearchCond;
import dbteam4.booksale.service.BookService;
import dbteam4.booksale.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final BookService bookService;
    @GetMapping()
    public String search(@RequestParam("keyword") String keyword, @RequestParam("condition") String condition, Model model)
    {
        keyword = keyword.replaceAll(" ", "");
        BookSearchCond bookSearchCond = new BookSearchCond(keyword, BookSearchType.valueOf(condition));

        List<BookPostsDTO> booksWithsPosts = bookService.findAll(bookSearchCond);
        model.addAttribute("booksWithsPosts", booksWithsPosts);

        return "search";
    }

    @GetMapping("{bookISBN}")
    public String selected(@PathVariable String bookISBN, Model model) {

        BookPostsDTO bookPostsDTO = bookService.findBookWithPostsByISBN(bookISBN);
        model.addAttribute("bookPostsDTO", bookPostsDTO);

        return "selected";
    }
}