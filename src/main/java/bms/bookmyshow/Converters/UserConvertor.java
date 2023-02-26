package bms.bookmyshow.Converters;

import bms.bookmyshow.Entities.User;
import bms.bookmyshow.EntryDtos.UserEntryDto;

public class UserConvertor {

    //Static is kept to avoid calling it via objects/instances
    public static User convertDtoToEntity(UserEntryDto userEntryDto){

        User user =  User.builder().age(userEntryDto.getAge()).address(userEntryDto.getAddress())
                .email(userEntryDto.getEmail()).name(userEntryDto.getName()).mobNo(userEntryDto.getMobNo())
                .build();

        return user;

    }

}