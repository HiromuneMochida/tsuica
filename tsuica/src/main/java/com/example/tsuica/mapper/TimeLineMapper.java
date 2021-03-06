package com.example.tsuica.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.tsuica.entity.TimeLineEntity;
import com.example.tsuica.form.TimeLineForm;

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
  public List<TimeLineEntity> searchTimeLine(TimeLineForm form);

  /** タイムラインログインユーザー検索 */
  public List<TimeLineEntity> findByLoginUser(String postUser);
}