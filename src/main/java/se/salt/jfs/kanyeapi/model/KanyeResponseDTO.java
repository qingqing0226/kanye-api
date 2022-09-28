package se.salt.jfs.kanyeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KanyeResponseDTO (
        @JsonProperty("quote") String text
){
}
