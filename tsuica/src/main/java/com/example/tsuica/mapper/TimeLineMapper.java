package com.example.tsuica.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.tsuica.entity.TimeLineEntity;

/**
 * タイムラインマッパークラス
 * @author hiromune mochida
 * @version 2021/01/30
 */
@Mapper
public interface TimeLineMapper {
  /** タイムライン一覧取得 */
  public TimeLineEntity selectTimeLine(TimeLineEntity entity);
}
