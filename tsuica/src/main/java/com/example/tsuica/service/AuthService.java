package com.example.tsuica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tsuica.entity.AccountEntity;
import com.example.tsuica.mapper.AuthMapper;

/**
*
* アカウント認証クラス
* @author hiromune mochida
* @version 2021/01/18
*
*/
@Service
public class AuthService implements UserDetailsService {
  @Autowired
  private AuthMapper loginMapper;

  /**
  * @param userName ユーザー名
  * @return UserDetails
  */
  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    AccountEntity user = loginMapper.selectLoginUser(userName);

    if (user == null || "".equals(userName)) {
      throw new UsernameNotFoundException("");
    }
    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
    GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
    grantList.add(authority);
    UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);

    return userDetails;

  }

}
