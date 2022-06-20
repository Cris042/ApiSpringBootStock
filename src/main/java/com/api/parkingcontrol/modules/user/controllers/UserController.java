package com.api.parkingcontrol.modules.user.controllers;

import com.api.parkingcontrol.modules.user.dtos.UserDto;
import com.api.parkingcontrol.modules.user.entities.UserEntities;
import com.api.parkingcontrol.modules.user.services.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveuserSpot(@RequestBody @Valid UserDto UserDto){     
        if(userService.existsByName(UserDto.getName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: user Name is already in use!");
        }
       
        var userModel = new UserEntities();
        BeanUtils.copyProperties(UserDto, userModel);
        userModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<Page<UserEntities>> getAlluserSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneuserSpot(@PathVariable(value = "id") UUID id){
        Optional<UserEntities> userSpotModelOptional = userService.findById(id);
        if (!userSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteuserSpot(@PathVariable(value = "id") UUID id){
        Optional<UserEntities> userSpotModelOptional = userService.findById(id);
        if (!userSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Spot not found.");
        }
        userService.delete(userSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("user Spot deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateuserSpot(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid UserDto UserDto){
        Optional<UserEntities> userSpotModelOptional = userService.findById(id);
        if (!userSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Spot not found.");
        }
        var userSpotModel = new UserEntities();
        BeanUtils.copyProperties(UserDto, userSpotModel);
        userSpotModel.setId(userSpotModelOptional.get().getId());
        userSpotModel.setRegistrationDate(userSpotModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userSpotModel));
    }



}
