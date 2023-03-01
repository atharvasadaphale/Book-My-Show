package bms.bookmyshow.Services;

import bms.bookmyshow.Converters.ShowConverters;
import bms.bookmyshow.Entities.*;
import bms.bookmyshow.EntryDtos.ShowEntryDto;
import bms.bookmyshow.Enums.SeatType;
import bms.bookmyshow.Repository.MovieRepository;
import bms.bookmyshow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;


    public String addShow(ShowEntryDto showEntryDto){

        Show show= ShowConverters.convertEntrytoEntity(showEntryDto);

        int movieId= showEntryDto.getMovieId();
        int theatreId=showEntryDto.getTheatreId();

        Movie movie= movieRepository.findById(movieId).get();

        Theatre theatre=theatreRepository.findById(theatreId).get();

        //setting attributes of foreign key

        show.setMovie(movie);
        show.setTheatre(theatre);

        //list of show seats pending

        List<ShowSeat> showSeatList= createShowSeat(showEntryDto, show);
        //creating showseat entity
        show.setListOfShowSeats(showSeatList);


        //now we update parent entities

        List<Show> shows=movie.getShowEntityList();
        shows.add(show);
        movie.setShowEntityList(shows);
        movieRepository.save(movie);

        List<Show> shows1=theatre.getShowEntityList();
        shows1.add(show);
        theatre.setShowEntityList(shows1);
        theatreRepository.save(theatre);

        return "Show added successfully";
    }
    public List<ShowSeat> createShowSeat(ShowEntryDto showEntryDto,Show show){


        //setting its attributes

        Theatre theatre=show.getTheatre();

        List<TheatreSeat> theatreSeatList=theatre.getTheaterSeatEntityList();

        List<ShowSeat> showSeatList=new ArrayList<>();

        for(TheatreSeat theatreSeat: theatreSeatList){
            ShowSeat showSeat=new ShowSeat();
            showSeat.setSeatNo(theatreSeat.getSeatNo());
            showSeat.setSeatType(theatreSeat.getSeatType());

            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showEntryDto.getClassicSeatPrice());
            }
            else{
                showSeat.setPrice((showEntryDto.getPremiunSeatprice()));
            }

            showSeat.setBooked(false);
            showSeat.setShow(show);

            showSeatList.add(showSeat);//adding to list
        }

        return showSeatList;
    }
}
