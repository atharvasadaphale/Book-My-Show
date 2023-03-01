package bms.bookmyshow.Converters;

import bms.bookmyshow.Entities.Show;
import bms.bookmyshow.EntryDtos.ShowEntryDto;

public class ShowConverters {
    public static Show convertEntrytoEntity(ShowEntryDto showEntryDto){
        Show show=Show.builder().showDate(showEntryDto.getLocalDate())
                .showType(showEntryDto.getShowtype())
                .showTime(showEntryDto.getLocalTime())
                .build();

        return show;
    }
}
