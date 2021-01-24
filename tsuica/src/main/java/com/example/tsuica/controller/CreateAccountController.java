package com.example.tsuica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tsuica.form.AccountForm;

@Controller
@RequestMapping("/signup")
public class CreateAccountController {

  /**
   * @param model
   * @param form
   * @return signup
   */
  @GetMapping
  public String getSignUp(Model model, AccountForm form) {
    model.addAttribute("AccountForm", form);
    return "auth/signup";
  }
}
