package com.example.tsuica.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.tsuica.common.Constant;
import com.example.tsuica.common.MessageManager;
import com.example.tsuica.entity.AccountEntity;
import com.example.tsuica.form.AccountForm;
import com.example.tsuica.helper.CreateAccountHelper;
import com.example.tsuica.service.AuthService;

/**
 * アカウント新規登録クラス
 * @author hiromune mochida
 *
 */
@Controller
public class CreateAccountController {

  @Autowired
  AuthService service;
  @Autowired
  CreateAccountHelper helper;
  @Autowired
  MessageManager msg;

  /**
   * アカウント登録画面表示
   * @param model
   * @param form
   * @return signup.html
   */
  @RequestMapping(value="/signup",method = RequestMethod.GET)
  public String init(Model model, AccountForm form) {
    model.addAttribute("AccountForm", form);

    return "auth/signup";
  }

  /**
   * アカウント登録処理
   * @param entity
   * @param form
   * @return
   */
  @RequestMapping(value="/regist",method = RequestMethod.POST)
  public String regist(@Validated @ModelAttribute AccountForm form, AccountEntity entity,
      BindingResult result, Model model) {

    //フォームからエンティティへ変換
    entity = helper.formToEntity(form, entity);
    //存在チェック
    long checkExist = service.countAccount(entity);
    if (checkExist != 0) {
      //アカウントが存在している場合
      model.addAttribute("errMsg", msg.getMessage(Constant.E_001));
      return "redirect:/signup";
    } else if (!StringUtils.isBlank(form.getUserName()) && !StringUtils.isBlank(form.getPassword())) {
      service.insertAccount(entity);
    }
    return "redirect:/login";
  }
}
