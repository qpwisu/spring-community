package com.hany.springcommunity.dto.member.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MemberDeleteResponse {
        @Schema(description = "회원 삭제 성공 여부", example = "true")
        private boolean result;
        public MemberDeleteResponse(boolean result) {
                this.result = result;
        }
}
