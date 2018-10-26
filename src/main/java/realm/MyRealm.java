package realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.Permission;
import pojo.User;
import service.ShiroService;
import service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Resource
    private UserService userService;

    @Resource
    private ShiroService shiroService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<String> permissions = shiroService.getAllResources();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        logger.debug(user.toString());
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(username), getName());
    }

    @Override
    public String getName() {
        return "MyRealm";
    }

}
