package bms.bookmyshow.EntryDtos;

import bms.bookmyshow.Enums.Genre;
import bms.bookmyshow.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MovieEntryDto {

    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;

}