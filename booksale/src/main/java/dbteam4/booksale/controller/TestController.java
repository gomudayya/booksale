package dbteam4.booksale.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.service.BookApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final BookApiService bookApiService;
    @GetMapping()
    public String useBookAPI() {
        String ISBN = "9788960779761";
        BookDTO bookData = bookApiService.getBookData(ISBN);
        bookApiService.saveBook(bookData.getISBN());
        System.out.println("bookData = " + bookData);
        return "index";
    }
}
