package com.example.tsuica.common;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 共通部品クラス
 * @author hiromune mochida
 * @version 2021/01/18
 */
public class Util {
  @Autowired
  /**
   * nullか空文字の場合(*)をセットする
   * @param target
   * @return String
   */
  public static String setWildCard(String target) {
    if (target.isEmpty()) {
      return Constant.WILD_CARD;
    } else {
      return target;
    }
  }


}
