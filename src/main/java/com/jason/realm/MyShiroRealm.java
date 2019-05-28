package com.jason.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by 我不管我最帅 on 2019/2/27.
 */
/*public class MyShiroRealm  extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    //授权  能进来说明认证成功
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=(String)principalCollection.getPrimaryPrincipal();
        //todo 通过service获取角色和权限
        Set<String> roles=roleService.listRoles(username);
        Set<String>permissions=permissionService.listPermissions(username);
        //授权对象
        SimpleAuthorizationInfo a=new SimpleAuthorizationInfo();
        a.setRoles(roles);
        a.setStringPermissions(permissions);
        return a;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken t=(UsernamePasswordToken)authenticationToken;
        //todo 获取账号密码
        String username=t.getPrincipal().toString();
        String password=new String(t.getPassword());
        //获取数据库中的密码
        String passwd=userService.getPassword(username);
        System.out.println("databaserealm:"+passwd);
        if(null==passwd||!passwd.equals(password)){
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo a=new SimpleAuthenticationInfo(username,password,getName());
        return a;

    }
}*/
