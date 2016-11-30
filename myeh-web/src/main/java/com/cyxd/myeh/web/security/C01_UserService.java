package com.cyxd.myeh.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 * <li>ClassFullName: com.cyxd.myeh.web.security.C01_UserService
 * <li>ClassName: C01_UserService
 * <li>CreateDateTime: 2016年11月28日 下午3:12:35
 *
 * <p>
 * Description:自定义用户业务类
 *
 * @author Slil
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see UserDetailsService
 * @see #loadUserByUsername
 *
 */
public class C01_UserService implements UserDetailsService {

    private DriverManagerDataSource dataSource;

    public void setDataSource(DriverManagerDataSource dataSource) {
	this.dataSource = dataSource;
    }

    private final static Logger logger = LoggerFactory.getLogger(C01_UserService.class);

    /** * 根据用户名获取用户 - 用户的角色、权限等信息 */
    @Override
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	UserDetails userDetails = null;
	try {
	    C01_User usr = new C01_User();
	    usr.setUsername("favccxx");
	    usr.setPassword("1b0e3809836e7bb9299b33679091485b29e00e9c87100db7284a5476473feea669b1313cab2348fa");
	    Collection<GrantedAuthority> authList = getAuthorities();
	    userDetails = new User(username, usr.getPassword(), true, true,
		    true, true, authList);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	if (logger.isInfoEnabled()) {
	    logger.info("userDetails-->" + userDetails);
	    logger.info("dataSource -->" + dataSource);
	}
	return userDetails;
    }

    /** * 获取用户的角色权限,为了降低实验的难度，这里去掉了根据用户名获取角色的步骤 * @param * @return */
    private Collection<GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
	authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	return authList;
    }

}