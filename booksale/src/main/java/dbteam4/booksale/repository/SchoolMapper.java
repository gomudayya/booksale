package dbteam4.booksale.repository;

import dbteam4.booksale.dto.SchoolDTO;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SchoolMapper {
    void save(SchoolDTO schoolDTO);
}
