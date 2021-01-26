package com.example.tsuica.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tsuica.entity.AccountEntity;
import com.example.tsuica.form.AccountForm;

/**
 * 認証ヘルパークラス
 * @author hiromune mochida
 * @version 2021/01/23
 */
@Service
public class CreateAccountHelper {
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  /**
   * フォームからエンティティへ変換
   * @param entity
   * @param form
   * @return AccountEntity
   */
  public AccountEntity formToEntity(AccountForm form, AccountEntity entity) {
    entity.setUserName(form.getUserName());
    entity.setPassword(passwordEncoder.encode(form.getPassword()));
    entity.setRole("ROLE_USER");
    return entity;
  }

}
