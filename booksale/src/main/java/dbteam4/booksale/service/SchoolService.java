package dbteam4.booksale.service;

import dbteam4.booksale.dto.SchoolDTO;
import dbteam4.booksale.repository.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolMapper schoolMapper;

    public void save(SchoolDTO schoolDTO){
        schoolMapper.save(schoolDTO);
    }
}
