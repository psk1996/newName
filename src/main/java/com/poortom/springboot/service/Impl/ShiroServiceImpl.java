//package com.poortom.springboot.service.Impl;
//
//import com.poortom.springboot.service.ShiroService ;
//import com.iyundao.io.mapper.SysMenuSqlMapper;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
//import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
//import org.apache.shiro.web.servlet.AbstractShiroFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by black on 2019/4/22.
// */
//@Service("shiroService")
//public class ShiroServiceImpl implements ShiroService {
//
//    @Autowired
//    SysMenuSqlMapper sysMenuSqlMapper;
//
//    /**
//     * 初始化权限
//     */
//    @Override
//    public Map<String, String> loadFilterChainDefinitions() {
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        //开放登陆接口
//        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
//        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
//        filterChainDefinitionMap.put("/v2/**", "anon");
//        filterChainDefinitionMap.put("/webjars/**", "anon");
//        filterChainDefinitionMap.put("/api/user/searchUserInfo", "anon");
//
//        filterChainDefinitionMap.put("/activity/**","anon");
//        filterChainDefinitionMap.put("/activitycategory/**", "anon");
//        filterChainDefinitionMap.put("/gift/**", "anon");
//        filterChainDefinitionMap.put("/image/**", "anon");
//        filterChainDefinitionMap.put("/integral", "anon");
//        filterChainDefinitionMap.put("/partymember", "anon");
//        filterChainDefinitionMap.put("/signin", "anon");
//        filterChainDefinitionMap.put("/sys/ueditor/**", "anon");
//        filterChainDefinitionMap.put("/wish/**", "anon");
//        filterChainDefinitionMap.put("/config/**", "anon");
//        filterChainDefinitionMap.put("/wechat/**", "anon");
//        filterChainDefinitionMap.put("/api/aliyun/**", "anon");
//        filterChainDefinitionMap.put("/resources/ueditor/**", "anon");
//
//        filterChainDefinitionMap.put("/api/user/searchCurrentUserUserInfo","authc");
//
//        List<Map> permissionList = sysMenuSqlMapper.selectPermission();
//        for(Map map : permissionList){
//            if(null != map.get("userName")){
//                filterChainDefinitionMap.put(map.get("menuUrl").toString(),"roles["+map.get("userName").toString()+"]");
//            }
//        }
//        //其余接口一律拦截
//        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
//        filterChainDefinitionMap.put("/**", "authc");
//        return filterChainDefinitionMap;
//    }
//
//    /**
//     * 在对角色进行增删改操作时，需要调用此方法进行动态刷新
//     * @param shiroFilterFactoryBean
//     */
//    @Override
//    public void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean, Integer roleId) {
//        synchronized (this) {
//            AbstractShiroFilter shiroFilter;
//            try {
//                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
//            } catch (Exception e) {
//                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
//            }
//            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
//            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
//            // 清空老的权限控制
//            manager.getFilterChains().clear();
//            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
//            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
//            // 重新构建生成
//            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
//            for (Map.Entry<String, String> entry : chains.entrySet()) {
//                String url = entry.getKey();
//                String chainDefinition = entry.getValue().trim().replace(" ", "");
//                manager.createChain(url, chainDefinition);
//            }
//
////            List<User> users = userMapper.findUsersByRoleId(roleId);
////
////            if (users.size() == 0) {
////                return;
////            }
////            for (User user : users) {
////                ShiroUtil.kickOutUser(user.getUsername(), false);
////            }
//        }
//    }
//}
