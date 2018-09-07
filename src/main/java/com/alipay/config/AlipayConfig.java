package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091600526506";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCJVqzNvgB7mt0A69wO50HC/TII72sZJc/c+9xmIAwKb5BwQCNlCTxGynsj7AE1NurUNKfFyImfcMEHVNOZoLFONSD/E/mtMW94+C0a4K6p8npx0FilSUcZpnObWmkuuBTiWEEcYU7O4vpXshs7v3L7iw4vx0QQs38OGcvjT9m+t87NolwIz8Y/rfCj8QYnaeit5/U8H70nBQWZ9jiGRPV9P0Ax24R2mDrm9pUaLU3EgRa+gQO4ldwlIOucYcSjE7uFw7z2INPwb1c2/PHE/0LVGL/g5LajoYvl7Skpk6zhay/lixHw8RhvSkP9M2Vnx/FmQB0/O/lnOWN8Wrj0mCHLAgMBAAECggEACQE22VKQ44nW3b2ZMxz0kd1aD33rLr3s8BdPbx7Ay1pfRQzfhTtiyV1zT3qk5aFRKlK9gVlRtLOG5H0qVpNTrMYNAMyFfVaVcYAMLQv4R8pPPvEjLsssL0FbqR73cIm/TMvukPbMXQJC2cciw/scheOrLXTKQLIULY+Bb8kHhNqdpbgDOX18GLxy8YlOG3aiGTWzToApuNG0waeexnjlPuVgmRi2bfhCouj/oA9XrYno2VIhqYSOiGSo9sWTt+OVkEpbWXR744JsnoafS3owPrBdFojHFg3AWvwaNhpp7ZgpjuvQRskh1QESbH9aWahfbsYeiRLTpgUN72EORbtsQQKBgQDRpQhkj4DBuIzNoAmga/mosoZpUcrYrZvdhYdYE1BcQrBF1JQPOD6Wqea+m+uzDHETdDKdqSkFWuPRQSQc0yjEpSfYqRKtbgMSiTaLF/ElsYHHry3YilacC5T2mYpoRF29gmGTw5/+RwKr8fwOePGRBLfvmezCyZA4SIwRxaMa6wKBgQCntL7ZD1boCYKA99rJ1ZulzrXvg+RHnEwMiLQyt/bwV4j9rCPMx8B+dPdhLwWB4fgowAfNNT4/SkHJyIgJjKNTlfbi8SOElMD6cxPrtEtvPh/jtLsev9GOKcrPmAqyLJEaB88px/Pyh+fUPd6UakvbGYfcq3vaSBExIloVLJecoQKBgQCA4fZw7A/6CFz3pOWGLBtF7MrZQKF15/UkkIyORwFmVtFLfM6xNKC1uynSEMUsQ//YN91OM8q2MhRQdr2ewuoTSn1eo0KKQFG/OX/Ary1fQOtKOZXzw8hPEoe3utjuFOmUMe2PC/r2Ne2ci52rwAqyXrY9pOF7NrNlBqSl4FzPlQKBgQCOJv/qPz1cG8t6BB15Hc38IpZGupZCOPKhYTLVFuiC2r/svf/ucZbx2bVitBfH+0F9USCLycjEnu3a21asOYCrth76SInhtLFK2UaWcVHLrm4bdjNyIge/qB8YDflrA6nO1bW85ZcbCiXw2qyTQvKfeimWW+j0okeoTUTsU8sDYQKBgDvr9fI9OXQKQcaHXExUeW4Ql4v3uVFR+U6cKDq/U+MCOQzjBH0dRnkXV3nnt/EK88GnOvWB0X7M887sj3IMLxEYrbPae9zDD+z5GjG9eOhh7hlJ1ms9SBsDXs3xbCUSvCM2o9ZfVOJ6YaOpvGLLEDmNC0ye6SXqGo8ka8rfvD0c";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiVaszb4Ae5rdAOvcDudBwv0yCO9rGSXP3PvcZiAMCm+QcEAjZQk8Rsp7I+wBNTbq1DSnxciJn3DBB1TTmaCxTjUg/xP5rTFvePgtGuCuqfJ6cdBYpUlHGaZzm1ppLrgU4lhBHGFOzuL6V7IbO79y+4sOL8dEELN/DhnL40/ZvrfOzaJcCM/GP63wo/EGJ2noref1PB+9JwUFmfY4hkT1fT9AMduEdpg65vaVGi1NxIEWvoEDuJXcJSDrnGHEoxO7hcO89iDT8G9XNvzxxP9C1Ri/4OS2o6GL5e0pKZOs4Wsv5YsR8PEYb0pD/TNlZ8fxZkAdPzv5ZzljfFq49JghywIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";

    public static String FORMAT = "json";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

