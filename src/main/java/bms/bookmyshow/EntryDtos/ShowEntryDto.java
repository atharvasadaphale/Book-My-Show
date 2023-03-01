package bms.bookmyshow.EntryDtos;

import bms.bookmyshow.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

    private LocalDate localDate;

    private LocalTime localTime;

    private ShowType showtype;

    private int movieId;

    private int theatreId;

    private int classicSeatPrice;

    private int premiunSeatprice;
}
