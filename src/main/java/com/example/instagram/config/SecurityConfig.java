package com.example.instagram.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor // final @NonNull 키워드가 해당하는 값만 매개변수로 받아 생성자를 만든다.
@EnableWebSecurity // 스프링 시큐리티 사용을 위한 어노테이션 선언
public class SecurityConfig extends WebSecurityConfigurerAdapter { // WebSecurityConfigurerAdapter 상속

    /*
        * 스프링 시큐리티 규칙
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Cross site request foreign CSRF 공격방지
        http.authorizeRequests()
                .antMatchers("/login", "/signup", "/style/**", "/js/**", "/img/**").permitAll() // antMathers 에는 권한 없이 접근을 허가해 줄 페이지 목록들을 적어
                .anyRequest().authenticated()
            .and()
                .formLogin() // 로그인과 관련된 부분을 해주면 된다.
                .loginPage("/login")
                .loginProcessingUrl("/loginForm")
                .defaultSuccessUrl("/")
            .and()
                .logout() // 로그아웃과 관련된 설정을 해주면 된다.
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true); // 세션 전체 삭제
    }


    /*
        * 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) {

    }
}
