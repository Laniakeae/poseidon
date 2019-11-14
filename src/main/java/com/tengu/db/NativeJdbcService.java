package com.tengu.db;

import com.tengu.model.TenguResultSet;

/**
 * @author 404NotFoundx
 * @version 1.0.0
 * @date 2019/11/13 16:57
 * @since 1.8
 */
public interface NativeJdbcService {

    /**
     * 执行任何sql语句
     * @param sql
     * @param args
     * @return
     */
    boolean execute(String sql,Object... args);

    /**
     * 执行查询
     * @param sql
     * @param args
     * @return
     */
    TenguResultSet executeQuery(String sql, Object... args);

}