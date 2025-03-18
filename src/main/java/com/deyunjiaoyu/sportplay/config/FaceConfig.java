package com.deyunjiaoyu.sportplay.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.deyunjiaoyu.sportplay.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanyongpeng
 * <p>des</p>
 **/
@Component
@Slf4j
public class FaceConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String faceToken = request.getHeader("facetoken");
        Map<String, String> infoMap = new HashMap<>();

        try {
            DecodedJWT tokenInfo = JwtUtils.getTokenInfo(faceToken);
            infoMap.put("msg","验证成功");
            // 如果需要，可以在这里添加额外的逻辑来处理 tokenInfo
            return true; // 继续处理请求
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            infoMap.put("msg", "无效签名");
        } catch (TokenExpiredException e) {
            infoMap.put("msg", "token已过期");
        } catch (AlgorithmMismatchException e) {
            infoMap.put("msg", "算法不一致");
        } catch (Exception e) {
            infoMap.put("msg", "无效签名");
        }

        // 将错误信息写入响应
        ObjectMapper objectMapper = new ObjectMapper();
        String mapInfoJson = objectMapper.writeValueAsString(infoMap);
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(mapInfoJson);
        writer.flush();
        writer.close();

        // 即使验证失败，也继续处理请求
        return true;
    }

}
