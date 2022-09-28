package se.salt.jfs.kanyeapi.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.UUID;

@Repository
public class QuoteRepository {
    private static final Map<UUID, Quote> quoteRepository = new HashMap<>();

    public boolean addQuote(Quote quoteToAdd) {
        quoteRepository.put(quoteToAdd.id(), quoteToAdd);
        return quoteRepository.containsKey(quoteToAdd.id());
    }
    public boolean removeQuote(UUID id) {
        quoteRepository.remove(id);
        return !quoteRepository.containsKey(id);
    }

    public Quote getQuoteById(UUID quoteId) {
        return quoteRepository.get(quoteId);
    }

    public List<Quote> listQuotes(){
        return new ArrayList<>(quoteRepository.values());
    }
}
