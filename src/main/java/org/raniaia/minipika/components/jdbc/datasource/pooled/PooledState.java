package org.raniaia.minipika.components.jdbc.datasource.pooled;

/*
 * Copyright (C) 2020 tiansheng All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Creates on 2020/6/1.
 */

import org.raniaia.minipika.framework.PropertyNames;
import org.raniaia.minipika.framework.util.Lists;
import org.raniaia.minipika.framework.util.Maps;
import org.raniaia.minipika.framework.util.StringUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author tiansheng
 */
public class PooledState {

  private PooledDataSource pooledDataSource;

  /**
   * sql执行耗时
   */
  protected Map<String, Long> sqlExecuteTimeCount           = Maps.newHashMap();

  protected List<PooledConnection> idleConnections          = Lists.newArrayList();
  protected List<PooledConnection> activeConnections        = Lists.newArrayList();

  protected long requestCount                               = 0L;   // 链接请求次数统计
  protected long badConnectionCount                         = 0L;   // 无效链接总数
  protected long requestAccumulateTime                      = 0L;   // 链接请求时间统计
  protected long hadToWaitCount                             = 0L;   // 当前有多少个链接在等待中
  protected long accumulateCreatesCount                     = 0L;   // 链接创建统计
  protected long maximumConnections                         = 10L;  // 最大连接数
  protected long minimumConnections                         = 5L;   // 最小连接数
  protected long currentConnectionsCount                    = 0L;   // 当前总连接数
  protected long maximumWaitTimeout                         = 0L;   // 链接最长等待时间
  protected long maximumWaitTimeoutCount                    = 0L;   // 链接等待时间统计

  public PooledState() {
  }

  public PooledState(PooledDataSource dataSource) {
    {
      this.pooledDataSource = dataSource;
    }
    {
      // 最大连接数
      long max = StringUtils.asLong(System.getProperty(PropertyNames.MAX_CONNECTION));
      if (max != 0L) {
        this.maximumConnections = max;
      }
      // 最小连接数
      long min = StringUtils.asLong(System.getProperty(PropertyNames.MIN_CONNECTION));
      if (min != 0L) {
        this.minimumConnections = min;
      }
    }
  }

  /**
   * 获取单条sql执行耗时
   */
  public long getSQLExecuteTime(String key) {
    return sqlExecuteTimeCount.get(key);
  }

  public synchronized long getRequestCount() {
    return this.requestCount;
  }

  public synchronized long getRequestAccumulateTime() {
    return this.requestAccumulateTime;
  }

  public synchronized long getBadConnectionCount() {
    return this.badConnectionCount;
  }

  public synchronized long getHadToWaitCount() {
    return this.hadToWaitCount;
  }

  public synchronized long getAccumulateCreatesCount() {
    return this.accumulateCreatesCount;
  }

}
