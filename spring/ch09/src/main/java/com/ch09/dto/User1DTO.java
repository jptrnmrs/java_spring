package com.ch09.dto;

import com.ch09.entity.User1;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {
    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,10}$",message = "영어 소문자와 숫자로 4-10자 입력")
    private String uid;

    @NotEmpty
    @Pattern(regexp = "^[가-힣]{2,10}$",message = "한글 2~10자 입력")
    private String name;

    @NotNull
    private String birth;
    private String hp;

    @Min(5)
    @Max(100)
    private int age;

    public User1 toEntity() {
        return User1.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
