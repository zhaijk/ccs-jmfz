package com.derun.jczb;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
//import org.apache.shiro.SecurityUtils;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.derun.jczb.dao.UserInfoMapper;
import com.derun.jczb.model.UserInfo;

@Component
public class CustomRealm extends AuthorizingRealm {

	 
    private final static Logger logger = LoggerFactory.getLogger(CustomRealm.class);
    @Autowired
    private UserInfoMapper userinfoMapper;
    
    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    	logger.info("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserInfo login_obj=new UserInfo();
        login_obj.setLoginname(token.getUsername());
        login_obj.setPassword(token.getPassword().toString());
        
        UserInfo obj=userinfoMapper.queryByUsername(login_obj);
        if(null==obj) {
        	throw new AccountException("用户名、密码不正确");
        }
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
    	logger.info("————权限认证————");
    	String userName=(String)principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		/*//Connection con=null;
		try{
			con=dbUtil.getCon();
			authorizationInfo.setRoles(userDao.getRoles(con,userName));
			authorizationInfo.setStringPermissions(userDao.getPermissions(con,userName));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		return authorizationInfo;
    }
//    token.getUsername()  //获得用户名 String
//    token.getPrincipal() //获得用户名 Object 
//    token.getPassword()  //获得密码 char[]
//    token.getCredentials() //获得密码 Object
}