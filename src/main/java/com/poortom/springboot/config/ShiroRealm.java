//package com.poortom.springboot.config;
//
//import com.iyundao.io.mapper.*;
//import com.iyundao.io.model.SysMenu;
//import com.iyundao.io.model.SysRole;
//import com.iyundao.io.model.SysUserProvider;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by black on 2019/3/20.
// */
//public class ShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private SysUserSqlMapper sysUserSqlMapper;
//
//    @Autowired
//    private SysRoleSqlMapper sysRoleSqlMapper;
//
//    @Autowired
//    private SysMenuSqlMapper sysMenuSqlMapper;
//
//    @Autowired
//    private SysDeptSqlMapper sysDeptSqlMapper;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("————权限认证————");
//        SysUserProvider sysUser = (SysUserProvider) SecurityUtils.getSubject().getPrincipal();
//        SysRole role =  sysUser.getSysRole();
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Set<String> setRoles = new HashSet<>();
//        Set<String> setPermissions = new HashSet<>();
//        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
//        setRoles.add(role.getSid());
//        List<SysMenu> menuList = sysMenuSqlMapper.selectAllMenuByRoleId(role.getSid());
//        for(SysMenu sysMenu : menuList){
//            setPermissions.add(sysMenu.getMenuUrl());
//        }
//        //设置该用户拥有的角色
//        info.setRoles(setRoles);
//        //设置权限
//        info.setStringPermissions(setPermissions);
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("————身份认证方法————");
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//
//        // 从数据库获取对应用户名密码的用户
//        SysUserProvider sysUser = sysUserSqlMapper.selectUserByLoginName(token.getUsername());
//        if(null == sysUser){
//            throw new AccountException("101");
//        }else {
//            if(sysUser.getFlag().equals("0")){
//                throw new AccountException("110");
//            }
//        }
//
//        sysUser.setSysRole(sysRoleSqlMapper.selectByUserId(sysUser.getSid()));
//        sysUser.setSysDept(sysDeptSqlMapper.selectByUserId(sysUser.getSid()));
//
//
//        return new SimpleAuthenticationInfo(sysUser, sysUser.getLoginPwd(), getName());
//    }
//}
