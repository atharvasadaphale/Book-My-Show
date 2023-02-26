package bms.bookmyshow.Services;

import bms.bookmyshow.Converters.MovieConvertors;
import bms.bookmyshow.Entities.Movie;
import bms.bookmyshow.EntryDtos.MovieEntryDto;
import bms.bookmyshow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{


        Movie movie = MovieConvertors.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movie);

        return "Movie Added successfully";


    }

}
