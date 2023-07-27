package com.hany.springcommunity.dto.member.response;

import com.hany.springcommunity.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MemberUpdateResponse {
    @Schema(description = "회원 정보 수정 성공 여부", example = "true")
    private boolean result;

    @Schema(description = "회원 이름", example = "콜라곰")
    private String name;

    @Schema(description = "회원 나이", example = "30")
    private Integer age;

    public static MemberUpdateResponse toDto(boolean result, Member member) {
        MemberUpdateResponse memberUpdateResponse = new MemberUpdateResponse();
        memberUpdateResponse.setResult(result);
        memberUpdateResponse.setName(member.getName());
        memberUpdateResponse.setAge(member.getAge());
        return memberUpdateResponse;
    }
}
