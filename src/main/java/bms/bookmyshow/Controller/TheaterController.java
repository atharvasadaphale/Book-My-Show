package bms.bookmyshow.Controller;


import bms.bookmyshow.EntryDtos.TheatreEntryDto;
import bms.bookmyshow.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheaterController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/addtheatre")
    public ResponseEntity<String> addTheater(@RequestBody TheatreEntryDto theaterEntryDto) {
        try {
            String result = theatreService.addTheater(theaterEntryDto);
            return new ResponseEntity(result, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}