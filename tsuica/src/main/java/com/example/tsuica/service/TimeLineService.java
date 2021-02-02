package com.example.tsuica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsuica.entity.TimeLineEntity;
import com.example.tsuica.form.TimeLineForm;
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

  /**
   * タイムライン一覧取得
   * @param entity
   * @return List<TimeLineEntity>
   */
  public List<TimeLineEntity> selectTimeLine(TimeLineEntity entity) {

    return mapper.selectTimeLine(entity);
  }

  /**
  * タイムライン検索
  * @param keyword
  * @param entity
  * @return List<TimeLineEntity>
  */
  public List<TimeLineEntity> searchTimeLine(TimeLineForm form) {


    return mapper.searchTimeLine(form);
  }

}