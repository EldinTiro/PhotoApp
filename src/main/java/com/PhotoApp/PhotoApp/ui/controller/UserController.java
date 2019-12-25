package com.PhotoApp.PhotoApp.ui.controller;

import com.PhotoApp.PhotoApp.shared.dto.UserDto;
import com.PhotoApp.PhotoApp.ui.model.request.UpdateUserDetailsRequestModel;
import com.PhotoApp.PhotoApp.ui.model.request.UserDetailsRequestModel;
import com.PhotoApp.PhotoApp.ui.model.response.UserRest;
import com.PhotoApp.PhotoApp.userservice.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    IUserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", required = false) String sort) {
        return "get users was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        //if(true) throw new UserServiceException("A user service exception is thrown");

        if (users.containsKey(userId))
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public UserRest createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnedValue = new UserRest();
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userDetails,userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnedValue);

        return returnedValue;


    }

    @PutMapping(path = "/{userId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(updateUserDetails.getFirstName());
        storedUserDetails.setLastName(updateUserDetails.getLastName());

        users.put(userId,storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();

    }
}
