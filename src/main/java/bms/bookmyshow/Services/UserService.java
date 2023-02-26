package bms.bookmyshow.Services;

import bms.bookmyshow.Converters.UserConvertor;
import bms.bookmyshow.Entities.User;
import bms.bookmyshow.EntryDtos.UserEntryDto;
import bms.bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto)throws Exception,NullPointerException{

        User user = UserConvertor.convertDtoToEntity(userEntryDto);

        userRepository.save(user);

        return "User Added successfully";

    }

}
