package com.data2.binlog.pop.process;

import org.apache.commons.lang.SystemUtils;

/**
 * @author data2
 * @description
 * @date 2021/4/23 下午6:05
 */
public class Format {

    public static final String SEP = SystemUtils.LINE_SEPARATOR;
    public static final String context_format = SEP
            + "****************************************************" + SEP
            +"* Batch Id: [{}] ,count : [{}] , memsize : [{}] , Time : {}"+SEP
            +"* Start : [{}] "+SEP
            +"* End : [{}] "+SEP
            +"****************************************************"+SEP;

    public static final String row_format = SEP
            + "----------------> binlog[{}:{}] , name[{},{}] , eventType : {} , executeTime : {}({}) , gtid : ({}) , delay : {} ms"
            + SEP;

    public static final String transaction_format = SEP
            + "================> binlog[{}:{}] , executeTime : {}({}) , gtid : ({}) , delay : {}ms"
            + SEP;

}

