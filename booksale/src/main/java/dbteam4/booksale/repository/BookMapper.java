package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Book;
import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.dto.BookPostsDTO;
import dbteam4.booksale.dto.BookSearchCond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    void save(BookDTO bookDTO);

    Book findByISBN(String ISBN);

    BookPostsDTO findBookWithPostsByISBN(String ISBN);
    List<BookPostsDTO> findAll(BookSearchCond bookSearchCond);

}
