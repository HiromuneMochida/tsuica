package com.example.tsuica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  public String init(Model model) {


    return "timeline/index";
  }

  @RequestMapping(value = "/timeline/search", method = RequestMethod.POST)
  public String search(@Validated @ModelAttribute TimeLineForm form, Model model) {

    List<TimeLineEntity> entity = service.searchTimeLine(form);

    model.addAttribute("entity", entity);

    return "timeline/index";
  }

}