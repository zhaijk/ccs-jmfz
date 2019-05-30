package com.derun.jczb;

import java.util.HashSet;
import java.util.Set;

//import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.shiro.subject.Subject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.derun.jczb.dao.UserInfoMapper;
import com.derun.jczb.model.UserInfo;
//import com.derun.jczb.model.UserInfoIccard;
import com.derun.jczb.model.Userbaseinfo;
import com.derun.jczb.util.SessionInfo;

@Component
public class JCZBRealm extends AuthorizingRealm {
	 
    private final static transient Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    
    @Autowired
    private UserInfoMapper userinfoMapper;    
    @Autowired
    private SessionInfo session;
    /**  身份认证    
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

    	UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;    	
    	String username=token.getUsername();
    	String password=new String(token.getPassword());
    	Userbaseinfo wujing_user=userinfoMapper.queryWujingByUsername(username,password);
    	SimpleAuthenticationInfo result = null;//=new SimpleAuthenticationInfo(wujing_user, token.getPassword(), getName());
    	try {
    		if(null!=wujing_user.getLoginname()) {
    			result=new SimpleAuthenticationInfo(wujing_user, token.getPassword(), getName());
    		}
    	}catch(NullPointerException e1) {
    		UserInfo iccard_user=userinfoMapper.queryIccardByUsername(username,password);
    		try {
        		if(null==iccard_user.getLogin_name())
        			throw new AccountException("用户名、密码不正确");
        		result=new SimpleAuthenticationInfo(iccard_user, token.getPassword(), getName());
        	}catch(NullPointerException e2) {
        		throw new AccountException("用户名、密码不正确");
        	}
    	}
    	return result;
    }

    /**
     * info 授权操作
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	System.out.println("doGetAuthorizationInfo 授权操作......................................");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String role = "admin";
	    Set<String> set = new HashSet<>();	   
	    set.add(role);
	    //设置该用户拥有的角色
	    authorizationInfo.setRoles(set);
	    String roles = session.getRoleName();
	    Set<String> permissions = (Set<String>) userinfoMapper.queryRolesByName(roles);	   
	    //设置该用户拥有的权限
	    authorizationInfo.setStringPermissions(permissions);
	    //Subject subject = SecurityUtils.getSubject();
	    
        return authorizationInfo;        
    }
//    token.getUsername()  //获得用户名 String
//    token.getPrincipal() //获得用户名 Object 
//    token.getPassword()  //获得密码 char[]
//    token.getCredentials() //获得密码 Object

	/*@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("授权...................");
		return null;
	}*/
}