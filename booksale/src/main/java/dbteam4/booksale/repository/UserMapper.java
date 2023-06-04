package dbteam4.booksale.repository;


import dbteam4.booksale.domain.User;
import dbteam4.booksale.dto.RegisterDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    void save(RegisterDTO registerDTO);

    User findByLoginID(String userID);

    User findById(Long id);

}
