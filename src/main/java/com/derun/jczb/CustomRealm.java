package com.derun.jczb;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import com.derun.jczb.dao.UserInfoMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import com.derun.jczb.dao.UserInfoMapper;
import com.derun.jczb.model.UserInfoIccard;

@Component
public class CustomRealm extends AuthorizingRealm {
	 
    private final static Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    @Autowired
    private UserInfoMapper userinfoMapper;
    
    /**
     *   info 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    	//System.out.println("token.getPrincipal:" + authenticationToken.getPrincipal());
        //System.out.println("token.getCredentials:" + authenticationToken.getCredentials());
    	UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    	UserInfoIccard user=new UserInfoIccard();
    	//System.out.println("token:    "+token.getUsername()+" "+new String(token.getPassword()));
    	user.setLogin_name(token.getUsername());
    	user.setLogin_password(new String(token.getPassword()));
    	//System.out.println("user:    "+user.getLogin_name()+" "+user.getLogin_password());
    	UserInfoIccard obj=userinfoMapper.queryByUsername(user);
        //Subject subject = SecurityUtils.getSubject();
        //UsernamePasswordToken token = new UsernamePasswordToken(obj.getLogin_name(), obj.getLogin_password());
        //subject.login(token);
        
        
        //UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //System.out.println("token.getPrincipal:" + token.getPrincipal());
        //System.out.println("token.getCredentials:" + token.getCredentials().toString());
        
        logger.info("————身份认证方法————"+token.getUsername()+"--"+new String(token.getPassword()));
        //SecurityUtils.getSubject().getSession();
        
        //Subject subject=SecurityUtils.getSubject();
        //subject.s
        //subject.isPermitted("");
        //        UserInfoIccard login_obj=new UserInfoIccard();
//        login_obj.setLogin_name(token.getUsername());
//        login_obj.setLogin_password(new String(token.getPassword()));        
        //login_obj.setLogin_password(token.getPassword());
        
        //UserInfoIccard obj=userinfoMapper.queryByUsername(login_obj);
        /*if(null==obj) {
        	throw new AccountException("用户名、密码不正确");
        }*/
//        // 从数据库获取对应用户名密码的用户
//        String password = userMapper.getPassword(token.getUsername());
//        if (null == password) {
//            throw new AccountException("用户名不正确");
//        } else if (!password.equals(new String((char[]) token.getCredentials()))) {
//            throw new AccountException("密码不正确");
//        }
        SimpleAuthenticationInfo result=new SimpleAuthenticationInfo(token.getPrincipal(), token.getPassword(), token.getUsername());
        return result;
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	/*//logger.info("————权限认证————");
    	String userName=(String)principalCollection.getPrimaryPrincipal();
    	logger.info("————权限认证————"+userName+"  "+principalCollection.toString());
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(null);
		authorizationInfo.setStringPermissions(null);*/
    	logger.info("————权限认证————"+SecurityUtils.getSubject().getPrincipal());
//    	String userName=(String)principalCollection.getPrimaryPrincipal();
    	
    	//logger.info(userName+": "+principalCollection+" "+SecurityUtils.getSubject().getSession());
	    //String username = (String) SecurityUtils.getSubject().getSession().get.getSubject().getPrincipal();
	    //logger.info("————2权3限认4证5————"+username);
    	
	    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();	    
	    //获得该用户角色
	   String role = "admin";
	    Set<String> set = new HashSet<>();
	    //需要将 role 封装到 Set 作为 info.setRoles() 的参数
	    set.add(role);
	    //设置该用户拥有的角色
	    info.setRoles(set);
	    //SecurityUtils.getSubject().checkPermission("");
	    //Set<String> stringPermissions = new HashSet<>();
//	    info.setStringPermissions(stringPermissions);
	    //info.addStringPermissions(stringPermissions);
	    
	    return info;
		//return authorizationInfo;
    }
//    token.getUsername()  //获得用户名 String
//    token.getPrincipal() //获得用户名 Object 
//    token.getPassword()  //获得密码 char[]
//    token.getCredentials() //获得密码 Object
}