package com.example.tsuica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tsuica.common.Constant;
import com.example.tsuica.common.MessageManager;

/**
 * ユーザー認証コントローラークラス
 * @author hiromune mochida
 * @version 2021/01/16
 */

@Controller
public class AuthController {
  @Autowired
  private MessageManager msg;

  /**
   *  ログイン画面表示
   * @return login.html
   */
  @GetMapping("/login")
  public String init() {

    return "auth/login";
  }

  /**
   * 入力情報送信
   * @return index.html
   */
  @PostMapping("/login")
  public String login() {

    return "redirect:tsuica/home";
  }

  /**
   * ログアウト
   * @return login.html
   */
  @PostMapping("/logout")
  public String logout() {

    return "redirect:auth/login";
  }

  /**
   *
   * @param model
   * @return index.html
   */
  //TODO 適切なフォルダに移動予定
  @GetMapping("/tsuica/home")
  public String index(Model model) {
    model.addAttribute("iMsg", msg.getMessage(Constant.I_001));

    return "tsuica/home";
  }
}
