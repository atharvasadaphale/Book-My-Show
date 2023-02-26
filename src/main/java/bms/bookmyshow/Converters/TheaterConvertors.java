package bms.bookmyshow.Converters;


import bms.bookmyshow.Entities.Theatre;
import bms.bookmyshow.EntryDtos.TheatreEntryDto;

public class TheaterConvertors {


    public static Theatre convertDtoToEntity(TheatreEntryDto theaterEntryDto){

        return Theatre.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();

    }

}