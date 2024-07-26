package com.guilherme.Place_Service.dtos;

import java.time.LocalDateTime;

public record PlaceDTO(String name, String slug, String city, String state) {
}
