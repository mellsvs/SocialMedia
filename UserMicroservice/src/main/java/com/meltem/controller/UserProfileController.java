package com.meltem.controller;

import com.meltem.document.UserProfile;
import com.meltem.dto.request.CreateUserRequestDto;
import com.meltem.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.meltem.config.RestApis.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto) {
        userProfileService.createUser(dto);
        return ResponseEntity.ok(true);

    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(userProfileService.getAll());
    }

}
