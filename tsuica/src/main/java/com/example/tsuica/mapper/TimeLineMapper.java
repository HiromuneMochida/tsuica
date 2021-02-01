package com.example.tsuica.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.tsuica.entity.TimeLineEntity;

/**
 * タイムラインマッパークラス
 * @author hiromune mochida
 * @version 2021/01/30
 */
@Mapper
public interface TimeLineMapper {
  /** タイムライン一覧取得 */
  public List<TimeLineEntity> selectTimeLine(TimeLineEntity entity);

  /** タイムライン検索 */
  public List<TimeLineEntity> searchTimeLine(@Param("keyword") String keyword, @Param("entity") TimeLineEntity entity);
}