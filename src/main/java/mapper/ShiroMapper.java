package mapper;


import org.springframework.stereotype.Repository;
import pojo.Permission;

import java.util.List;

@Repository
public interface ShiroMapper {

    List<Permission> selectAll();

    List<String> selectAllResources();

    int savePermission(Permission permission);
}
