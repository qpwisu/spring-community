package com.hany.springcommunity.service;

import com.hany.springcommunity.common.MemberType;
import com.hany.springcommunity.dto.member.response.MemberInfoResponse;
import com.hany.springcommunity.entity.Category;
import com.hany.springcommunity.repository.CategoryRepository;
import com.hany.springcommunity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<MemberInfoResponse> getMembers() {
        return memberRepository.findAllByType(MemberType.USER).stream()
                .map(MemberInfoResponse::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<MemberInfoResponse> getAdmins() {
        return memberRepository.findAllByType(MemberType.ADMIN).stream()
                .map(MemberInfoResponse::toDto)
                .toList();
    }
    @Transactional
    public Category createCategory(String name){
        if(!categoryRepository.existsByName(name)){
            throw new IllegalArgumentException("이미 존재하는 카테고리 입니다");
        }
        return categoryRepository.save(Category.builder().name(name).build());
    }

}
