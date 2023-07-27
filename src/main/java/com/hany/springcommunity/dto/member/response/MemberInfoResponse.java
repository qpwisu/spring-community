package com.hany.springcommunity.dto.member.response;

import com.hany.springcommunity.common.MemberType;
import com.hany.springcommunity.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MemberInfoResponse {
    @Schema(description = "회원 고유키", example = "c0a80121-7aeb-4b4b-8b0a-6b1c032f0e4a")
    private UUID id;

    @Schema(description = "회원 아이디", example = "hany")
    private String account;

    @Schema(description = "회원 이름", example = "콜라곰")
    private String name;

    @Schema(description = "회원 나이", example = "30")
    private Integer age;

    @Schema(description = "회원 타입", example = "USER")
    private MemberType type;

    @Schema(description = "회원 생성일", example = "2023-05-11T15:00:00")
    private LocalDateTime createdAt;

    public static MemberInfoResponse toDto(Member member) {
        MemberInfoResponse memberInfoResponse = new MemberInfoResponse();
        memberInfoResponse.setId(member.getId());
        memberInfoResponse.setAccount(member.getAccount());
        memberInfoResponse.setName(member.getName());
        memberInfoResponse.setAge(member.getAge());
        memberInfoResponse.setType(member.getType());
        memberInfoResponse.setCreatedAt(member.getCreatedAt());
        return memberInfoResponse;
    }
}
