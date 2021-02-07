package com.example.tsuica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.tsuica.entity.TimeLineEntity;
import com.example.tsuica.form.TimeLineForm;
import com.example.tsuica.service.TimeLineService;

/**
 * タイムラインコントローラークラス
 * @author hiromune mochida
 * @version 2021/01/30
 */
@Controller
public class TimeLineController {

  @Autowired
  private TimeLineService service;

  /**
   * タイムライン画面初期表示
   * @param entity
   * @param model
   * @return
   */
  @RequestMapping(value = "/timeline/index", method = RequestMethod.GET)
  public String init(TimeLineEntity entity, Model model) {

    List<TimeLineEntity> selectEntity = service.selectTimeLine(entity);

    model.addAttribute("selectEntity", selectEntity);

    return "timeline/index";
  }

  /**
   * タイムライン検索結果表示
   * @param entity
   * @param model
   * @return
   */
  @RequestMapping(value = "/timeline/search", method = RequestMethod.POST)
  public String search(@Validated @ModelAttribute TimeLineForm form, Model model) {

    List<TimeLineEntity> searchEntity = service.searchTimeLine(form);

    model.addAttribute("searchEntity", searchEntity);

    return "timeline/index";
  }

  /**
   * ユーザータイムライン表示
   * @param entity
   * @param model
   * @return
   */
  @RequestMapping(value = "/timeline/show", method = RequestMethod.GET)
  public String findByName(TimeLineEntity entity, Model model) {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //ログインユーザー名取得
    String postUser = auth.getName();

    List<TimeLineEntity> userEntity = service.findByLoginUser(postUser);

    model.addAttribute("userEntity", userEntity);

    return "timeline/show";
  }

}