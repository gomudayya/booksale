package dbteam4.booksale.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dbteam4.booksale.dto.BookDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BookApiServiceTest {

    private BookApiService bookApiService = new BookApiService();

    @Test
    void getBookData() throws JsonProcessingException {
        String testISBN = "9788960174191";
        BookDTO bookDTO = bookApiService.getBookData(testISBN);

        String resultTitle = "제노사이드 (다카노 가즈아키 장편소설)";
        assertThat(bookDTO.getTitle()).isEqualTo(resultTitle);
    }
}