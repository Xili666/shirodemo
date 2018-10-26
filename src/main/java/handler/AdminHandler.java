package handler;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminHandler {

    private Logger logger = LoggerFactory.getLogger(AdminHandler.class);

    @RequiresPermissions("admin:save")
    @ResponseBody
    @RequestMapping("/save")
    public Map<String, Object> save() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "admin-save");
        logger.debug("admin-save");
        return map;
    }


    @RequiresPermissions("admin:del")
    @ResponseBody
    @RequestMapping("/del")
    public Map<String, Object> del() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "admin-del");
        logger.debug("admin-del");
        return map;
    }
}
