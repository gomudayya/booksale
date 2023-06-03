package dbteam4.booksale.repository;


import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;


@Mapper
public interface UserMapper {
    void save(UserDTO userDTO);

    User findByLoginID(String userID);

    User findById(Long id);

}
