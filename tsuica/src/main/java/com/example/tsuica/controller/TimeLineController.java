package com.example.tsuica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

  /**
   * タイムライン画面初期表示
   * @param entity
   * @param model
   * @return
   */
  @RequestMapping(value = "/timeline/index", method = RequestMethod.GET)
  public String index(TimeLineEntity entity, Model model) {

    List<TimeLineEntity> entities = service.selectTimeLine(entity);

    model.addAttribute("entities", entities);

    return "timeline/index";
  }
  @RequestMapping(value = "/timeline/search", method = RequestMethod.POST)
  public String search(TimeLineEntity entity, Model model,@RequestParam String keyword) {

    List<TimeLineEntity> result = service.searchTimeLine(keyword,entity);

    model.addAttribute("result", result);

    return "timeline/index";
  }

}
