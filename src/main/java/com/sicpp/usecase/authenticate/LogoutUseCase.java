package com.sicpp.usecase.authenticate;

import com.sicpp.infrastructure.dto.request.LogoutRequest;
import com.sicpp.infrastructure.dto.response.LogoutResponse;

public interface LogoutUseCase {LogoutResponse execute(LogoutRequest request);}
