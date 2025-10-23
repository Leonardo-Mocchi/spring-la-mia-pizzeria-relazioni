package org.lessons.java.spring_la_mia_pizzeria_crud.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "special_offer")
public class SpecialOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "The Beginning date of the Special Offer MUST NOT BE NULL")
    @PastOrPresent(message = "The Beginning date of the Special Offer MUST NOT BE IN THE FUTURE")
    private LocalDate offerFirstDay;

    @NotNull(message = "The Ending date of the Special Offer MUST NOT BE NULL")
    @PastOrPresent(message = "The Ending date of the Special Offer MUST NOT BE IN THE FUTURE")
    private LocalDate offerLastDay;

    @NotBlank(message = "The name of the Special Offer MUST NOT BE NULL, EMPTY NOR BLANK")
    private String title;

    @OneToMany(mappedBy = "specialOffer")
    private List<Pizza> pizzas;
}
