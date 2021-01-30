package com.example.tsuica.entity;

import lombok.Data;

/**
 * タイムラインエンティティクラス
 * @author hiromune mochida
 * @version 2021/01/30
 */
@Data
public class TimeLineEntity {

  /** 投稿ID */
  private Integer postId;

  /** 投稿内容 */
  private String content;

  /** 投稿者 */
  private String user;

  /** 削除フラグ */
  private String delFlg;



}
