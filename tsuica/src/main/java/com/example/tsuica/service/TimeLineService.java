package com.example.tsuica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsuica.entity.TimeLineEntity;
import com.example.tsuica.mapper.TimeLineMapper;

/**
 * タイムラインサービスクラス
 * @author hiromune mochida
 * @version 2021/01/30
 */
@Service
public class TimeLineService {
  @Autowired
  private TimeLineMapper mapper;

  public List<TimeLineEntity> selectTimeLine(TimeLineEntity entity) {

    return mapper.selectTimeLine(entity);
  }

}
