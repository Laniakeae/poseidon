package org.laniakeamly.poseidon.experiment;

import org.laniakeamly.poseidon.framework.limit.Column;
import org.laniakeamly.poseidon.framework.limit.Model;
import org.laniakeamly.poseidon.framework.limit.PrimaryKey;

/**
 * Copyright: Create by 2BKeyboard on 2020/1/11 2:57
 */
@Model("te")
public class Test {

    @PrimaryKey
    @Column("int(11) not null")
    private Long id;

}
