package com.example.tsuica.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.tsuica.entity.AccountEntity;

@Mapper
public interface CreateAccountMapper {

  /**
   * アカウント作成
   * @param アカウントエンティティ
   * @return AccountEntity
   */
  public void insertAccount(AccountEntity entity);

  /**
   * アカウント重複チェック
   * @param アカウントエンティティ
   * @return AccountEntity
   */
  public long countAccount(AccountEntity entity);
  //TODO 要修正
}
