package dbteam4.booksale.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dbteam4.booksale.domain.Book;
import dbteam4.booksale.dto.BookDTO;
import dbteam4.booksale.repository.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookApiService {

    private final BookMapper bookMapper;
    private final String bookURL = "https://openapi.naver.com/v1/search/book_adv.xml";
    private final String naverClientID = "xjq2M8oWWnuITSg4O_jw";
    private final String naverClientSecret = "xPWTZ3k2gu";

    public void saveBook(String ISBN) {
        Book bookInDB = bookMapper.findByISBN(ISBN);
        System.out.println("bookInDB = " + bookInDB);

        if (bookInDB == null) {
            BookDTO bookData = getBookData(ISBN);
            bookMapper.save(bookData);
        }
    }

    public BookDTO getBookData(String ISBN) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-Naver-Client-Id", naverClientID);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_XML);

        HttpEntity request = new HttpEntity(headers);

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(bookURL)
                .queryParam("d_isbn", ISBN)
                .encode()
                .toUriString();

//        log.info(urlTemplate);

        ResponseEntity<String> response = restTemplate.exchange(urlTemplate, HttpMethod.GET, request, String.class);
//        log.info(response.getBody());

        String parsedXML = parseForBookInfo(response.getBody());
        BookDTO bookDTO = xmlToObject(parsedXML);

        log.info(bookDTO.toString());

        return bookDTO;
    }

    private String parseForBookInfo(String xml) {
        String startToken = "<item>";
        String endToken = "</item>";

        int startNum = xml.indexOf(startToken);
        int endNum = xml.indexOf(endToken);

        return xml.substring(startNum, endNum + endToken.length());
    }

    private BookDTO xmlToObject(String xml)  {
        XmlMapper xmlMapper = new XmlMapper();
        BookDTO bookDTO = null;
        try {
            bookDTO = xmlMapper.readValue(xml, BookDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return bookDTO;
    }
}
