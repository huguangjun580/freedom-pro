package cn.qlfbbs.its.assembly.service;

import cn.hutool.http.HttpUtil;
import cn.qlfbbs.its.assembly.properties.AppletProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huguangjun
 */
public class AppletService {

    private AppletProperties appletProperties;

    public AppletProperties getAppletProperties() {
        return appletProperties;
    }

    public void setAppletProperties(AppletProperties appletProperties) {
        this.appletProperties = appletProperties;
    }

    // 微信小程序登录返回

    /**
     * 微信小程序登录返回 json object
     */
    public Object login(String code) {
        // return {"session_key":"2YvmBg1qCRlFsW+lhc85bg==","openid":"o_UzA4tmBROpoUjLPID-t1kNCFLE"}
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("appid", appletProperties.getAppId());
            param.put("secret", appletProperties.getSecret());
            param.put("js_code", code);
            param.put("grant_type", appletProperties.getLoginGrantType());
            return HttpUtil.get(appletProperties.getLogin(), param);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 获取 token
     *
     */
    public Object getToken() {
        // @return {"access_token":"46_2f8JtnifQBKF4GSvLyayR_nbzdZNVGUkTVBERDrHqpMJHA_mPIK-EP_Bi70M8R2GDRuL4DtuwjJDruPHaeTFjiB71uBq2fL9e8N8u2KfqEOEIXiYd3GckjtUS7nDzCsp1Hma8jQHl2h40SGlRORdADAWTW","expires_in":7200}
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("appid", appletProperties.getAppId());
            param.put("secret", appletProperties.getSecret());
            param.put("grant_type", appletProperties.getTokenGrantType());
            return HttpUtil.get(appletProperties.getToken(), param);
        } catch (Exception e) {
            throw e;
        }
    }
}
