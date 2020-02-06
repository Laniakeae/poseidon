package org.laniakeamly.poseidon.timer;

import org.laniakeamly.poseidon.framework.timer.Timer;
import org.laniakeamly.poseidon.framework.tools.TimeUtils;

/**
 * Copyright: Create by 2BKeyboard on 2019/12/9 11:18
 */
public class Timer1 implements Timer {

    @Override
    public void run() {

        System.out.println("timer1");

    }

    @Override
    public long time() {
        return TimeUtils.SECOND * 5;
    }
}
