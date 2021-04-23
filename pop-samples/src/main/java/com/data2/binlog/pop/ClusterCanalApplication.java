package com.data2.binlog.pop;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.data2.binlog.pop.process.MessageProcess;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author data2
 * @description
 * @date 2021/4/23 下午4:31
 */
@SpringBootApplication
public class ClusterCanalApplication extends MessageProcess implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ClusterCanalApplication.class);
    }

    public void run(String... args) throws Exception {
        CanalConnector connector = CanalConnectors.newClusterConnector(
                "127.0.0.1:2181", "example",
                "example", "");

        connector.connect();
        connector.subscribe("database\\.table");

        this.connector = connector;
        process();


    }



}
