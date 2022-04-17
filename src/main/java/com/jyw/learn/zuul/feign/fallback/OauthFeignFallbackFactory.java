package com.jyw.learn.zuul.feign.fallback;

import com.jyw.learn.zuul.bean.AjaxResult;
import com.jyw.learn.zuul.feign.OauthFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OauthFeignFallbackFactory implements FallbackFactory<OauthFeign> {
    @Override
    public OauthFeign create(Throwable throwable) {
        return new OauthFeign() {

            @Override
            public AjaxResult checkToken(String accessToken) {
                return AjaxResult.failure("10900","未知异常");
            }
        };
    }
}
