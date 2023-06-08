package dbteam4.booksale.repository;

import dbteam4.booksale.domain.Book;
import dbteam4.booksale.dto.BookDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    void save(BookDTO bookDTO);

    Book findByISBN(String ISBN);

}
