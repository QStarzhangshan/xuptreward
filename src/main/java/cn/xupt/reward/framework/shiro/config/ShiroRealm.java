package cn.xupt.reward.framework.shiro.config;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.xupt.reward.common.utils.security.ShiroUtils;
import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.service.PermissionService;
import cn.xupt.reward.project.user.service.RoleService;
import cn.xupt.reward.project.user.service.UserService;
import cn.xupt.reward.util.Md5Util;


public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	Long colId = ShiroUtils.getColId();
    	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    	//查询用户角色
    	info.setRoles(roleService.selectRoleBycolId(colId));
    	//查询用户权限
    	info.setStringPermissions(permissionService.selectPermissionBycolId(colId));
    	return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
        //获取用户输入的账号
        UsernamePasswordToken token = (UsernamePasswordToken) authtoken;
        String colCode = token.getUsername();
        //char[] colPasswd = token.getPassword();
        String colPasswd = new String(token.getPassword());
        User user = userService.selectUserByColCode(colCode,colPasswd);
        if(user == null) throw new UnknownAccountException();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,colPasswd, getName());
        SecurityUtils.getSubject().getSession().setAttribute("userInfo", user);
        return info;
    }
    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo()
    {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}

