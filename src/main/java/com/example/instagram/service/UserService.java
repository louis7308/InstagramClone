package com.example.instagram.service;

import com.example.instagram.domain.user.User;
import com.example.instagram.domain.user.UserRepository;
import com.example.instagram.web.dto.user.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// Bean등록 코드 @Component, @Service, @Controller, @Repository, @Bean, @Configuration

@RequiredArgsConstructor // final 이나 @NonNull 인 필드 값만 파라미터로 받는 생성자를 만들어줍니다
@Service
public class UserService {

    private final UserRepository userRepository; // final 은 선언부에서 초기화를 하지 않으면 안된다.
    // 회원 정보 추가

    // 선언적 트랜젝션 (메소드, 클래스, 인터페이스)
    @Transactional // 트랜잭션 기능이 포함된 프록시 객체가 생성되어 자동으로 commit 혹은 rollback을 진행해준다.
    public boolean save(UserSignupDto userSignupDto) {
        if(userRepository.findUserByEmail(userSignupDto.getEmail()) != null) return false;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userRepository.save(User.builder()
                        .email(userSignupDto.getEmail())
                        .password(encoder.encode(userSignupDto.getPassword()))
                        .phone(userSignupDto.getPhone())
                        .name(userSignupDto.getName())
                        .title(null)
                        .website(null)
                        .profileImgUrl(null)
                .build());
        return true;
    }
}
