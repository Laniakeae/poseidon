package org.laniakeamly.poseidon.framework.cache;

import org.laniakeamly.poseidon.framework.db.NativeResult;

/**
 *
 * 缓存接口.
 *
 * Cache interface.
 *
 * Copyright: Create by 2BKeyboard on 2019/12/9 23:10
 *
 * @author TianSheng
 * @since 1.8
 */
public interface PoseidonCache {

    /**
     * 获取缓存
     * @param sql
     * @param args
     * @return
     */
    NativeResult get(String sql, Object... args);

    /**
     * 保存
     * @param sql
     * @param result
     * @param args
     * @return
     */
    void save(String sql, NativeResult result, Object... args);

    /**
     * 刷新缓存
     * @param sql
     */
    void refresh(String sql);

    /**
     * 刷新所有缓存
     */
    void refreshAll();

}
