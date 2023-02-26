package bms.bookmyshow.Controller;


import bms.bookmyshow.EntryDtos.TheatreEntryDto;
import bms.bookmyshow.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheatreService theatreService;

    public String addTheater(@RequestBody TheatreEntryDto theaterEntryDto){

        return "";

    }
}