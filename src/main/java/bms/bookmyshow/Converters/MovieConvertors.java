package bms.bookmyshow.Converters;
import bms.bookmyshow.Entities.Movie;
import bms.bookmyshow.EntryDtos.MovieEntryDto;

public class MovieConvertors {


    public static Movie convertEntryDtoToEntity(MovieEntryDto movieEntryDto){

        Movie movie =  Movie.builder()
                .movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre()).language(movieEntryDto.getLanguage()).ratings(movieEntryDto.getRatings()).build();

        return movie;
    }
}
