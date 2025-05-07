package dev.cbq.demo02.user.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record SignUpVo(@NotEmpty String username, @Email String email, @NotEmpty String password) {
}
