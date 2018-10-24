package com.example.demo.controller;

import com.example.demo.utils.CaptchaUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理验证码
 */
@Controller
public class CaptchaController {
  private   Logger logger=Logger.getLogger(this.getClass());


    /**
     * 响应并显示验证码图片
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/createCode")
    public  void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //通知浏览器不要缓存
        //控制缓存的失效日期
        response.setHeader("Expires","-1");
        //必须先与服务器确认返回的响应是否被更改，然后才能使用该响应来满足后续对同一个网址的请求
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","-1");
        CaptchaUtil captchaUtil=CaptchaUtil.Instance();
        //将验证码输入到session中，用来验证
        String code=captchaUtil.getString();
        request.getSession().setAttribute("code",code);
        //输出到web界面
        ImageIO.write(captchaUtil.getImage(),"jpg",response.getOutputStream());
    }

    /**
     * 比较用户输入的验证码是否正确。并返回结果。
     * @param name
     * @param password
     * @param code
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/checkLogin")
    public  void checkLogin(String name,String password ,String code,
                            HttpServletRequest request,HttpServletResponse response) throws Exception {
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        //取出存在session的随机数字
        String codeSession=(String)session.getAttribute("code");
        if(StringUtils.isEmpty(codeSession)) {
             logger.error("没有生成验证码信息");
             throw  new IllegalStateException("ERR-01000");
        }
        if(StringUtils.isEmpty(code)) {
            logger.error("未填写验证码信息");
            throw  new  Exception("ERR-06018");
        }

        if(codeSession.equalsIgnoreCase(code)) {
            out.print("trueCode");
        }else  {
            out.print("false");
        }

    }

}
