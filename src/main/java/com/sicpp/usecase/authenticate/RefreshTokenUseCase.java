package com.sicpp.usecase.authenticate;

import com.sicpp.infrastructure.dto.request.RefreshTokenRequest;
import com.sicpp.infrastructure.dto.response.RefreshTokenResponse;

public interface RefreshTokenUseCase {
    RefreshTokenResponse execute(RefreshTokenRequest request);
}
