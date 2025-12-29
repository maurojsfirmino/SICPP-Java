package com.sicpp.infrastructure.controller;

import com.sicpp.infrastructure.dto.request.CreateUserRequest;
import com.sicpp.infrastructure.dto.response.BaseResponse;
import com.sicpp.infrastructure.mapper.UserMapper;
import com.sicpp.usecase.user.CreateUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sicpp.infrastructure.utils.Utilities.log;

@RestController
@RequestMapping("api/v1/user")
@Tag(name = "Users")
public class UserController {
    final private CreateUserUseCase createUserUseCase;
    final private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    @Operation(summary = "Cadastrar usuário",description = "Cria um novo usuário no sistema e retorna os dados do usuário criado"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Returns successful message"),
            @ApiResponse(responseCode = "400", description = "Bad request happened"),
            @ApiResponse(responseCode = "409", description = "Conflict with business rules"),
            @ApiResponse(responseCode = "500", description = "An unexpected error occurred."),
    })
    public ResponseEntity<BaseResponse<String>> createUser(@Valid @RequestBody CreateUserRequest request) throws Exception {
        log.info("Inicio da criação do usuário::UserController");
        createUserUseCase.create(userMapper.toUser(request));
        log.info("Usuário criado com sucesso::UserController");
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.<String>builder().success(true).message("Usuário criado com sucesso").build());
    }
}
