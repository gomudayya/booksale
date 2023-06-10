package dbteam4.booksale.repository;


import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.PostBookDTO;
import dbteam4.booksale.dto.RegisterDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void save(RegisterDTO registerDTO);

    void update(@Param("id") Long id, @Param("userForm") RegisterDTO registerDTO);

    User findByLoginID(String userID);

    User findById(Long id);

}

