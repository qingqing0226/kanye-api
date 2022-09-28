package se.salt.jfs.kanyeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import se.salt.jfs.kanyeapi.model.KanyeResponseDTO;
import se.salt.jfs.kanyeapi.model.Quote;
import se.salt.jfs.kanyeapi.model.QuoteRepository;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/quotes")
public class QuotesController {

    @Autowired
    QuoteRepository quoteRepository;


    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Quote> putQuote(@RequestAttribute("createdAt") String createdAt) {
        RestTemplate template = new RestTemplate();
        ResponseEntity<KanyeResponseDTO> entity = template
                .getForEntity("https://api.kanye.rest/", KanyeResponseDTO.class);
        Quote quote = new Quote(entity.getBody().text(),
                createdAt,
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                UUID.randomUUID());
        // add quote to repo
        quoteRepository.addQuote(quote);

        return ResponseEntity.created(URI.create("/api/quotes/" + quote.id())).body(quote);
    }

    // getMapping (return a list quotes)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Quote> listQuotes(){
        return quoteRepository.listQuotes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Quote getSpecificQuote(@PathVariable UUID id){
        return quoteRepository.getQuoteById(id);
    }


}
