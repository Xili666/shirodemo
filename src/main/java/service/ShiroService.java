package service;

import pojo.Permission;

import java.util.List;

public interface ShiroService {

    List<Permission> getAllPermissions();

    List<String> getAllResources();

    void savePermission(Permission permission);
}
