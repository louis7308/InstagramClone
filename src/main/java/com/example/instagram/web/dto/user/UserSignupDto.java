package com.example.instagram.web.dto.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 만들어줍니다.
@Setter
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 다 모아놓은거
public class UserSignupDto {

    // @Null : null 만 허용합니다
    // @NotNull : null을 허용하지 않습니다. "", " "는 허용합니다.
    // @NotEmpty : null, ""를 허용하지 않습니다 " "는 허용합니다.
    // @NotBlank : null, "", " " 모두 허용하지 않습니다.

    // @Email : 이메일 형식을 검사합니다 다만 "" 의 경우는 통과시킵니다
    // @Pattern(regexp = ) : 정규식을 검사 할 때 사용됩니다
    // @Size :

    @Size(min = 2, max = 100, message = "이메일은 2글자 이상, 100글자 이하로 작성해 주세요.")
    @NotBlank(message = "이메일을 입력해 주세요.")
    @Email(message = "이메일 형식에 맞지 않습니다")
    private String email;

    @Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    @NotBlank(message = "비밀번호를 입력해 주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*$?&]{8,}$",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 이상의 비밀번호여야 합니다.")
    private String password;

    @NotBlank(message = "전화번호를 입력해 주세요.")
    @Pattern(regexp = "^[0-9]+$", message = "전화 번호는 숫자로만 입력해 주세요.")
    private String phone;

    @Size(min = 1, max = 30, message = "이름은 1글자 이상, 30글자 이내로 작성해 주세요.")
    @NotBlank(message = "이름을 입력해 주세요.")
    private String name;
}
