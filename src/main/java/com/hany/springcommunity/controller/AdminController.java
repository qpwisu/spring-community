package com.hany.springcommunity.controller;

import com.hany.springcommunity.dto.ApiResponse;
import com.hany.springcommunity.security.AdminAuthorize;
import com.hany.springcommunity.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "관리자용 API")
@RequiredArgsConstructor
@AdminAuthorize
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Operation(summary = "회원 목록 조회")
    @GetMapping("/members")
    public ApiResponse getAllMembers() {
        return ApiResponse.success(adminService.getMembers());
    }

    @Operation(summary = "관리자 목록 조회")
    @GetMapping("/admins")
    public ApiResponse getAllAdmins() {
        return ApiResponse.success(adminService.getAdmins());
    }
    @Operation(summary = "카테고리 추가")
    @PostMapping("/category")
    public ApiResponse CreateCategory(@RequestParam String name){return ApiResponse.success(adminService.createCategory(name));}
}
