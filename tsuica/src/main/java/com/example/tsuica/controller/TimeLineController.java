package com.example.tsuica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.tsuica.entity.TimeLineEntity;
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

  @RequestMapping(value = "/timeline/index", method = RequestMethod.GET)
  public String indexs(TimeLineEntity entity, Model model) {

    entity = service.selectTimeLine(entity);

    model.addAttribute("entity", entity);

    return "timeline/index";
  }

}
