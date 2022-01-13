package com.gh.javase.io;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

/**
 * @author sso team
 * @description
 * @date 2021/11/10 9:59 上午
 */
public class DateTest {

    @Test
    public void toolTest() {
        DateTime currentTime = DateUtil.date(System.currentTimeMillis());
        System.out.println(currentTime);
        DateTime offset = currentTime.offset(DateField.MILLISECOND, -20 * 1000);
        System.out.println(offset);
    }

}
