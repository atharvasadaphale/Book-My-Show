package bms.bookmyshow.Services;

import bms.bookmyshow.Converters.TheaterConvertors;
import bms.bookmyshow.Entities.Theatre;
import bms.bookmyshow.Entities.TheatreSeat;
import bms.bookmyshow.EntryDtos.TheatreEntryDto;
import bms.bookmyshow.Enums.SeatType;
import bms.bookmyshow.Repository.TheatreRepository;
import bms.bookmyshow.Repository.TheatreSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    
    @Autowired
    TheatreRepository theatreRepository;


    public String addTheater(TheatreEntryDto theaterEntryDto) throws Exception {
        if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){
            throw new Exception("Name and location not valid.");
        }

        Theatre theatre = TheaterConvertors.convertDtoToEntity(theaterEntryDto);

        List<TheatreSeat> theatreSeatList = createTheaterSeats(theaterEntryDto,theatre);

        theatre.setTheaterSeatEntityList(theatreSeatList);
        theatreRepository.save(theatre);

        return "Theatre added successfully";
    }

    private List<TheatreSeat> createTheaterSeats(TheatreEntryDto theatreEntryDto,Theatre theatre){


        int noClassicSeats = theatreEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theatreEntryDto.getPremiumSeatsCount();

        List<TheatreSeat> theatreSeatList = new ArrayList<>();


        //Created the classic Seats
        for(int count = 1;count<=noClassicSeats;count++){

            //We need to make a new TheaterSeatEntity
            TheatreSeat theaterSeatEntity = TheatreSeat.builder()
                    .seatType(SeatType.CLASSIC).seatNo(count+"C")
                    .theatre(theatre).build();

            theatreSeatList.add(theaterSeatEntity);
        }


        //Create the premium Seats
        for(int count=1;count<=noPremiumSeats;count++){

            TheatreSeat theaterSeatEntity = TheatreSeat.builder().
                    seatType(SeatType.PREMIUM).seatNo(count+"P").theatre(theatre).build();

            theatreSeatList.add(theaterSeatEntity);

        }

        //theatreSeatRepository.saveAll(theatreSeatList);

        return theatreSeatList;

    }
}
