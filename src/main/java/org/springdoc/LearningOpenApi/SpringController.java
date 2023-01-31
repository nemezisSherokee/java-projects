package org.springdoc.LearningOpenApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springdoc.api.annotations.ParameterObject;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(description = "User API", name = "User Services")
@RestController
public class SpringController {

    private final AtomicInteger counter = new AtomicInteger();

    private final UserRepository userRepository;

    @Autowired
    public SpringController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/filter")
        @Operation(summary = "Returns all users", tags = {"User",},
                responses = {
                        @ApiResponse(responseCode = "200",
                                description = "Returns all users",
                                content = @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = User.class)))
                })
    public List<User> filterBooks(@ParameterObject Pageable pageable) {
        return  userRepository.findAll();
    }


    @GetMapping("/users")
    @Operation(summary = "Returns all users", tags = {"User",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns all users",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)))
            })
    @ResponseBody
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @Operation(summary = "Register a new user",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns the registered user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)))
            })
    @ResponseBody
    public User register(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        User newUser = new User(counter.incrementAndGet(), name);
        return userRepository.addUser(newUser);
    }

    @PutMapping("/users/{id}")
    @Operation(summary = "Update a user's name",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns the updated user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)))
            })
    @ResponseBody
    public User updateUser(@PathVariable(value = "id") int id, String newName) throws Exception {
        return userRepository.updateUser(id, newName).orElseThrow(() -> new Exception("Error! User not found!"));
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "Delete a user",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns a boolean",
                            content = @Content(mediaType = "application/json"))
            })
    @ResponseBody
    public Boolean deleteUser(@PathVariable(value = "id") int id) {
        return userRepository.deleteUser(id);
    }
}
