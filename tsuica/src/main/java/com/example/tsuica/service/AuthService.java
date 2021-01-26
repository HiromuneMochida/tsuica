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
import com.example.tsuica.mapper.CreateAccountMapper;

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
  @Autowired
  private CreateAccountMapper creteAccountMapper;

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

  /**
   * アカウント登録
   * @param entity
   * @return アカウントエンティティ
   */
  public void insertAccount(AccountEntity entity) {
    //TODO 処理
    creteAccountMapper.insertAccount(entity);
  }

  /**
   * アカウント削除フラグチェック
   * @param entity
   * @return 削除フラグ "0"
   */
  public long countAccount(AccountEntity entity) {
    //TODO 処理

    return creteAccountMapper.countAccount(entity);
  }
}
