package com.example.tsuica.form;

import java.io.Serializable;

import lombok.Data;

/**
 * タイムラインフォームクラス
 * @author hiromune mochida
 * @version 2021/01/31
 */
@Data
public class TimeLineForm implements Serializable {

  /** キーワード 検索用 */
  private String content;

  /** ユーザー名 検索用 */
  private String userName;

}
