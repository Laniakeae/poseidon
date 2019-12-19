package org.laniakeamly.poseidon.framework.db;

import org.laniakeamly.poseidon.framework.annotation.Valid;
import org.laniakeamly.poseidon.framework.sql.SqlMapper;

/**
 * Create by 2BKeyboard on 2019/12/19 14:20
 */
public class JdbcBuilderImpl implements JdbcBuilder {

    @Valid
    private NativeJdbc nativeJdbc;

    @Valid
    private JdbcSupport jdbcSupport;

    @Override
    public <T> T queryForObject(SqlMapper mapper) {
        return (T) jdbcSupport.queryForObject(mapper.getSql(),mapper.getResult(),mapper.getArgs());
    }
}
