package com.example.tsuica.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.tsuica.entity.AccountEntity;
import com.example.tsuica.form.AccountForm;

/**
 * 認証ヘルパークラス
 * @author hiromune mochida
 * @version 2021/01/23
 */
public class CreateAccountHelper {
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  /**
   * フォームからエンティティへ変換
   * @param entity
   * @param form
   * @return AccountEntity
   */
  public AccountEntity formToEntity(AccountEntity entity, AccountForm form) {
    entity.setUserName(form.getUserName());
    entity.setPassword(passwordEncoder.encode(form.getPassword()));
    entity.setRole("ROLE_USER");
    return entity;
  }

}
