package com.example.tsuica.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.tsuica.entity.AccountEntity;

/**
*
* @author hiromune mochida
* @version 2021/01/18
* ログインマッパークラス
*/
@Mapper
public interface AuthMapper {
  /**
   * ログイン情報取得
   * @param userName
   * @param password
   * @return AccountEntity
   */
  public AccountEntity selectLoginUser(String userName);


}

