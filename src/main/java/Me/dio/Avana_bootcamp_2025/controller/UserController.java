package Me.dio.Avana_bootcamp_2025.controller;


import Me.dio.Avana_bootcamp_2025.domain.model.User;
import Me.dio.Avana_bootcamp_2025.service.Userservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Userservice userservice;

    public UserController(Userservice userservice){
        this.userservice = userservice;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user= userservice.findByid(id);
        return ResponseEntity.ok(user);

    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate) {
        var userCreated= userservice.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);

    }

}
