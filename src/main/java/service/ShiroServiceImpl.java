package service;

import mapper.ShiroMapper;
import org.springframework.stereotype.Service;
import pojo.Permission;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private ShiroMapper shiroMapper;

    public List<Permission> getAllPermissions() {
        return shiroMapper.selectAll();
    }

    @Override
    public List<String> getAllResources() {
        return shiroMapper.selectAllResources();
    }

    @Override
    public void savePermission(Permission permission) {
        shiroMapper.savePermission(permission);
    }
}
