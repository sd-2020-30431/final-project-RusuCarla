package com.project.utilities.validators;

import com.project.presentation_layer.dto.UserDto;

import java.sql.Timestamp;

public class Validator {
    
    public static boolean validateUserDto(UserDto userDto) {
        if (userDto != null) {
            if (Validator.isAlphanumeric(userDto.getUsername())) {
                if(Validator.isAlphanumeric(userDto.getPassword()))
                    return true;
            }
        }
        return false;
    }
    
    private static boolean isNumeric(String string){
        return string.matches("[0-9]+");
    }

    private static boolean isAlpha(String string){
        return string.matches("[a-zA-Z]+");
    }

    private static boolean isName(String name) {
        return name.matches("^[ A-Za-z]+$");
    }

    private static boolean isAlphanumeric(String string) {
        return string.matches("[A-Za-z0-9]+");
    }

    private static boolean isStrictlyPositive(int i){
        return (i>0);
    }
}
