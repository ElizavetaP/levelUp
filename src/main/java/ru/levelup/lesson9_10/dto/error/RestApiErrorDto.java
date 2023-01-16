package ru.levelup.lesson9_10.dto.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RestApiErrorDto {

    private ApiError error;

    public RestApiErrorDto(String code) {
        this(code, null);
    }

    public RestApiErrorDto(String code, String message) {
        this.error = new ApiError();
        this.error.setCode(code);
        this.error.setMessage(message);
    }
}
