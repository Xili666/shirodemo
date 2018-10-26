package handler;

import org.apache.shiro.authc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GlobalHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalHandler.class);

    @RequestMapping("/index")
    public String index() {
        logger.debug("跳转 /index");
        return "index";
    }

    /**
     * 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
     * 登陆失败还到login页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(Map<String, Object> map, HttpServletRequest request) {
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                map.put("errorMsg", "账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                map.put("errorMsg", "用户名/密码错误");
            } else {
                map.put("errorMsg", "其他异常信息");
            }
        }
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
