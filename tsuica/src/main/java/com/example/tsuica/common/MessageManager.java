package com.example.tsuica.common;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * 共通メッセージクラス
 * @author hiromune mochida
 * @version 2021/01/23
 */
@Service
//@RequiredArgsConstructor
public class MessageManager {

  @Autowired
  MessageSource message;

  /**
   * メッセージ数 単一
   * @param target 出力メッセージ
   * @return String
   */
  public String getMessage(String target) {
    return message.getMessage(target, new String[] {}, Locale.JAPAN);
  }

  /**
   * 出力メッセージ数 組み合わせ
   * @param target 出力メッセージ
   * @param {0}{1}...
   * @return String
   */
  public String getMessage(String target, String... args) {
    return message.getMessage(target, args, Locale.JAPAN);
  }
}
