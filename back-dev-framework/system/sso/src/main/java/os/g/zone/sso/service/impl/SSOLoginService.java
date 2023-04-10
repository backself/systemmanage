package os.g.zone.sso.service.impl;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import os.g.zone.sso.security.UserLoginDetails;
import os.g.zone.sso.pojo.dto.SystemUserLoginParamsDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SSOLoginService {
    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.duration-in-minute}")
    private Long durationInMinute;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(SystemUserLoginParamsDTO systemUserLoginParamsDTO) {
        log.debug("开始处理【管理员登录】的业务，参数：{}", systemUserLoginParamsDTO);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                systemUserLoginParamsDTO.getUserName(), systemUserLoginParamsDTO.getUserPassword());
        Authentication authenticateResult
                = authenticationManager.authenticate(authentication);
        log.debug("认证通过！（如果未通过，过程中将抛出异常，你不会看到此条日志！）");
        log.debug("认证结果：{}", authenticateResult);
        log.debug("认证结果中的当事人：{}", authenticateResult.getPrincipal());

        // 使用JWT机制时，登录成功后不再需要将认证信息存入到SecurityContext
        // SecurityContext securityContext = SecurityContextHolder.getContext();
        // securityContext.setAuthentication(authenticateResult);

        // 需要存入到JWT中的数据
        UserLoginDetails userLoginDetails = (UserLoginDetails) authenticateResult.getPrincipal();
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userLoginDetails.getId());
        claims.put("username", userLoginDetails.getUsername());
        String authoritiesJsonString = JSON.toJSONString(userLoginDetails.getAuthorities());
        claims.put("authoritiesJsonString", authoritiesJsonString);

        // 生成JWT，以下代码是相对固定的
        String jwt = Jwts.builder()
                // Header：声明算法与Token类型
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                // Payload：数据，具体表现为Claims
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + durationInMinute * 60 * 1000))
                // Verify Signature：验证签名
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        log.debug("生成了JWT数据：{}", jwt);
        return jwt;
    }
}
