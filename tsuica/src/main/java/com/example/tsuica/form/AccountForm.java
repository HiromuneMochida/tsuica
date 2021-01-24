package com.example.tsuica.form;

import lombok.Data;
/**
 * アカウントフォームクラス
 * @author hiromune mochida
 *
 */
@Data
public class AccountForm {

  /** ユーザーID */
  private String userName;

  /** パスワード */
  private String password;

}
