package com.sicpp.infrastructure.controller;

import com.sicpp.infrastructure.dto.request.AuthenticateUserRequest;
import com.sicpp.infrastructure.dto.request.LogoutRequest;
import com.sicpp.infrastructure.dto.request.RefreshTokenRequest;
import com.sicpp.infrastructure.dto.response.AuthenticateUserResponse;
import com.sicpp.infrastructure.dto.response.BaseResponse;
import com.sicpp.infrastructure.dto.response.LogoutResponse;
import com.sicpp.infrastructure.dto.response.RefreshTokenResponse;
import com.sicpp.usecase.authenticate.AuthenticateUserUseCase;
import com.sicpp.usecase.authenticate.LogoutUseCase;
import com.sicpp.usecase.authenticate.RefreshTokenUseCase;

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
@RequestMapping("/auth")
@Tag(name = "Autenticação")
public class AuthController {

    private final AuthenticateUserUseCase authenticateUserUseCase;
    private final LogoutUseCase logoutUseCase;
    private final RefreshTokenUseCase refreshTokenUseCase;

    public AuthController(
            AuthenticateUserUseCase authenticateUserUseCase,
            LogoutUseCase logoutUseCase,
            RefreshTokenUseCase refreshTokenUseCase
    ) {
        this.authenticateUserUseCase = authenticateUserUseCase;
        this.logoutUseCase = logoutUseCase;
        this.refreshTokenUseCase = refreshTokenUseCase;
    }

    // ========================= LOGIN =========================

    @PostMapping("/login")
    @Operation(
            summary = "Login do usuário",
            description = "Autentica o usuário utilizando email e senha"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    public ResponseEntity<BaseResponse<AuthenticateUserResponse>> login(
            @Valid @RequestBody AuthenticateUserRequest request
    ) {
        log.info("Início do login::AuthController");

        AuthenticateUserResponse response =
                authenticateUserUseCase.execute(request);

        log.info("Login realizado com sucesso::AuthController");

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        BaseResponse.<AuthenticateUserResponse>builder()
                                .success(true)
                                .message("Login realizado com sucesso")
                                .result(response)
                                .build()
                );
    }

    // ========================= LOGOUT =========================

    @PostMapping("/logout")
    @Operation(summary = "Logout do usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logout realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Refresh token inválido")
    })
    public ResponseEntity<BaseResponse<LogoutResponse>> logout(
            @Valid @RequestBody LogoutRequest request
    ) {
        log.info("Início do logout::AuthController");

        LogoutResponse response = logoutUseCase.execute(request);

        log.info("Logout realizado com sucesso::AuthController");

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        BaseResponse.<LogoutResponse>builder()
                                .success(true)
                                .message("Logout realizado com sucesso")
                                .result(response)
                                .build()
                );
    }

    // ========================= REFRESH TOKEN =========================

    @PostMapping("/refresh")
    @Operation(summary = "Renovar access token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token renovado com sucesso"),
            @ApiResponse(responseCode = "401", description = "Refresh token inválido")
    })
    public ResponseEntity<BaseResponse<RefreshTokenResponse>> refresh(
            @Valid @RequestBody RefreshTokenRequest request
    ) {
        log.info("Início do refresh token::AuthController");

        RefreshTokenResponse response =
                refreshTokenUseCase.execute(request);

        log.info("Refresh token realizado com sucesso::AuthController");

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        BaseResponse.<RefreshTokenResponse>builder()
                                .success(true)
                                .message("Token renovado com sucesso")
                                .result(response)
                                .build()
                );
    }
}
