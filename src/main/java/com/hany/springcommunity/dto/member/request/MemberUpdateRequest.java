package com.hany.springcommunity.dto.member.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MemberUpdateRequest {
        @Schema(description = "회원 비밀번호", example = "1234")
        private String password;

        @Schema(description = "회원 새 비밀번호", example = "1234")
        private String newPassword;

        @Schema(description = "회원 이름", example = "콜라곰")
        private String name;

        @Schema(description = "회원 나이", example = "30")
        private Integer age;

}
