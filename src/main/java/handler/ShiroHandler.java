package handler;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import pojo.Permission;
import realm.PermissionName;
import service.ShiroService;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {

    @Resource
    private RequestMappingHandlerMapping rmhm;
    @Resource
    private ShiroService shiroService;

    @ResponseBody
    @RequestMapping("/nopermission")
    public Map<String, Object> noPermission() {
        Map<String, Object> map = new HashMap<>();
        map.put("ok", false);
        map.put("err-msg", "缺少权限");
        return map;
    }

    @ResponseBody
    @RequestMapping("/reload")
    public Map<String, Object> reload() {
        Map<String, Object> map = new HashMap<>();

        //0.从数据库中查询出所有权限表达式，然后对比，如果已经存在了，跳过，不存在添加
        List<String> resources = shiroService.getAllResources();

        //1:获取controller中所有带有@RequestMapper标签的方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            System.out.println(entry.getKey() + " ->\t" + entry.getValue() + "\n\t\t" + entry.getClass());
        }
        Collection<HandlerMethod> methods = handlerMethods.values();
        //2：遍历所有方法，判断当前方法是否贴有@RequiresPermissions权限控制标签
        for (HandlerMethod method : methods) {
            RequiresPermissions annotation = method.getMethodAnnotation(RequiresPermissions.class);
            if (annotation != null){
                // 3：如果有，解析得到权限表达式，封装成Permission对象保存到Permission表中
                String resource = annotation.value()[0];
                if (resources.contains(resource)){
                    continue;
                }
                Permission permission = new Permission();
                permission.setResource(resource);
//                permission.setName(method.getMethodAnnotation(PermissionName.class).value());
                shiroService.savePermission(permission);
            }
        }

        return map;
    }
}
