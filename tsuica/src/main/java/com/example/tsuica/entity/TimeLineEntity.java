package com.example.tsuica.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * タイムラインエンティティクラス
 * @author hiromune mochida
 * @version 2021/01/30
 */
@Data
public class TimeLineEntity implements Serializable {

  /** 投稿ID */
  private Integer postId;

  /** 投稿内容 */
  private String content;

  /** 投稿者 */
  private String postUser;

  /** 削除フラグ */
  private String delFlg;

  /** 作成日時 */
  private Date createdAt;

}
