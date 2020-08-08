package wrx.scs.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class STConfig extends WebSecurityConfigurerAdapter {


    // 设置没有密码加密
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 增加内存用户，基于内存的认证
        // 增加3个用户，给予不同的权限，权限有 ADMIN DBA USER
        auth.inMemoryAuthentication()
                .withUser("root").password("123").roles("ADMIN","DBA")
                .and()
                .withUser("admin").password("123").roles("ADMIN","USER")
                .and()
                .withUser("cc").password("123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .and()

                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                // 能访问 /admin的只有 "ADMIN" 权限
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')")
                // 能访问 /db/下的资源的用户，要同时拥有'ADMIN' 和 'DBA'
                .antMatchers("/db/**")
                .access("hasAnyRole('ADMIN') and  hasRole('DBA')")
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated();
    }


}
