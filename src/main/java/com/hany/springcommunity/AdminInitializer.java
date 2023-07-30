package com.hany.springcommunity;

import com.hany.springcommunity.common.MemberType;
import com.hany.springcommunity.entity.Category;
import com.hany.springcommunity.entity.Member;
import com.hany.springcommunity.repository.CategoryRepository;
import com.hany.springcommunity.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminInitializer implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final CategoryRepository categoryRepository;
    @Override
    public void run(ApplicationArguments args) {
        // Check if the "admin" account already exists
        if (!memberRepository.existsByAccount("admin")) {
            // If not, create a new "admin" account
            memberRepository.save(Member.builder()
                    .account("admin")
                    .password(encoder.encode("admin"))
                    .name("관리자")
                    .type(MemberType.ADMIN)
                    .build());
        }

        if (!categoryRepository.existsByName("자유게시판")) {
            // If not, create a new "admin" account
            categoryRepository.save(Category.builder().name("자유게시판").build());
        }
    }
}
