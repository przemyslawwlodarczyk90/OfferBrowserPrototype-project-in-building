package com.example.offerbrowserprototype.domain.dto.offer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class OfferDTO {

    private String id; // ID może być generowane przez bazę, więc może nie być konieczne walidowanie

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Location cannot be empty")
    private String location;

    private String salaryRange; // Optional field, no validation

    private String technologies; // Optional field, no validation

    private boolean applied;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private LocalDateTime fetchedAt; // Może być ustawiane przez system, więc bez walidacji



    // Konstruktor bez ID (dla tworzenia nowych ofert)
    public OfferDTO(String title, String description, String location, String salaryRange, String technologies, boolean applied, LocalDateTime fetchedAt) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.salaryRange = salaryRange;
        this.technologies = technologies;
        this.applied = applied; // Ustawienie pola 'applied'
        this.fetchedAt = fetchedAt; // Ustawienie pola 'fetchedAt'
    }

    // Konstruktor z ID (dla istniejących ofert)
    public OfferDTO(String id, String title, String description, String location, String salaryRange, String technologies, boolean applied, LocalDateTime fetchedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salaryRange = salaryRange;
        this.technologies = technologies;
        this.applied = applied; // Ustawienie pola 'applied'
        this.fetchedAt = fetchedAt; // Ustawienie pola 'fetchedAt'
    }

    public OfferDTO() {
    }


}
