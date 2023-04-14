
1、小程序根据code登录并返回json object。
示例：{"session_key":"2Yvg1qCsW+lhbg=XX","openid":"o_UzA4tmBROpoUjLPID-t1kNXXXX"}

2、小程序获取accessToken并返回json object。
示例：{"access_token":"46D2fxxx","expires_in":7200}


1、要使用的项目中先引入pom依赖。

<dependency>
    <groupId>cn.qlfbbs.its</groupId>
    <artifactId>wx-applet</artifactId>
    <version>1.0.1</version>
</dependency>
2、yml或yaml中配置小程序的appId、secret（这里必要核心动态配置最多的就是这两个属性，其它均采用默认）。

# 小程序参数配置
applet:
  appId: wx9f394feb2xxxxxxxxxx
  secret: bb8a9c9c21xxxxxxxxxx
元数据可配置选项：

{
  "properties": [
    {
      "name": "applet.appId",
      "description": "小程序 appId",
      "defaultValue": "appId"
    },
    {
      "name": "applet.secret",
      "description": "小程序 appSecret",
      "defaultValue": "appSecret"
    },
    {
      "name": "applet.login",
      "description": "登录凭证校验。通过 wx.login 接口获得临时登录凭证 code 后传到开发者服务器调用此接口完成登录流程。",
      "defaultValue": "https://api.weixin.qq.com/sns/jscode2session"
    },
    {
      "name": "applet.loginGrantType",
      "description": "授权类型，此处只需填写 authorization_code",
      "defaultValue": "authorization_code"
    },
    {
      "name": "applet.token",
      "description": "获取小程序全局唯一后台接口调用凭据（access_token）。调用绝大多数后台接口时都需使用 access_token，开发者需要进行妥善保存",
      "defaultValue": "https://api.weixin.qq.com/cgi-bin/token"
    },
    {
      "name": "applet.tokenGrantType",
      "description": "填写client_credential",
      "defaultValue": "client_credential"
    }
  ]
}
3、项目代码中使用

// 先添加依赖注入
@Resource
private AppletService appletService;

//根据需要方法内调用
Object open = appletService.login(code); // 登录返回openId
Object token = appletService.getToken(); // 根据appId和secret获取token
如图示例：
输入图片说明

4、既然可以获取到小程序的token，那么小程序组件可以根据token继续封装其它。
可以在源代码-configuration里面继续增加，这里略。如果感觉starter方式有点麻烦，可以用wx-applet文件源码方式install成jar上传私服这种单jar的形式。
