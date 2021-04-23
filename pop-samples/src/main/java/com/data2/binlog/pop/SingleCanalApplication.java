package com.data2.binlog.pop;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.data2.binlog.pop.process.MessageProcess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

/**
 * @author data2
 * @description
 * @date 2021/4/23 下午4:31
 */
@SpringBootApplication
public class SingleCanalApplication extends MessageProcess implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SingleCanalApplication.class);
    }

    public void run(String... args) throws Exception {
        CanalConnector connector = CanalConnectors.newSingleConnector(
                new InetSocketAddress(AddressUtils.getHostIp(), 11111),
                "example", "", "");

        connector.connect();
        connector.subscribe("database\\.table");

        this.connector = connector;
        process();

    }



}
