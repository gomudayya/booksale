package dbteam4.booksale.repository;


import dbteam4.booksale.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    void save(UserDTO userDTO);
}
