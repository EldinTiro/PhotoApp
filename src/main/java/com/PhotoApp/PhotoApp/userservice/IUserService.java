package com.PhotoApp.PhotoApp.userservice;


import com.PhotoApp.PhotoApp.shared.dto.UserDto;
import com.PhotoApp.PhotoApp.ui.model.request.UserDetailsRequestModel;
import com.PhotoApp.PhotoApp.ui.model.response.UserRest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    UserDto createUser(UserDto user);

    UserDto getUser(String email);

    UserDto getUserByUserId(String id);
}
