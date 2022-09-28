package se.salt.jfs.kanyeapi.model;

import java.util.UUID;

public record Quote(String text, String createdAt, String responseAt, UUID id) {
}
