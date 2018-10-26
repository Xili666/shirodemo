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
@RequestMapping("/emp")
public class EmployeeHandler {

    private Logger logger = LoggerFactory.getLogger(EmployeeHandler.class);

    @RequiresPermissions("emp:save")
    @ResponseBody
    @RequestMapping("/save")
    public Map<String, Object> save() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "emp-save");
        logger.debug("emp-save");
        return map;
    }


    @RequiresPermissions("emp:del")
    @ResponseBody
    @RequestMapping("/del")
    public Map<String, Object> del() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "emp-del");
        logger.debug("emp-del");
        return map;
    }

}
