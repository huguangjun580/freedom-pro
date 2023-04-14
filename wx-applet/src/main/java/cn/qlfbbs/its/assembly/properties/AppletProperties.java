package cn.qlfbbs.its.assembly.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huguangjun
 */
@ConfigurationProperties(prefix = "applet")
public class AppletProperties {

    private String appId = "your-appId";
    private String secret = "your-appSecret";
    private String login = "https://api.weixin.qq.com/sns/jscode2session";
    private String loginGrantType = "authorization_code";
    private String token = "https://api.weixin.qq.com/cgi-bin/token";
    private String tokenGrantType = "client_credential";

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLoginGrantType() {
        return loginGrantType;
    }

    public void setLoginGrantType(String loginGrantType) {
        this.loginGrantType = loginGrantType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenGrantType() {
        return tokenGrantType;
    }

    public void setTokenGrantType(String tokenGrantType) {
        this.tokenGrantType = tokenGrantType;
    }
}
