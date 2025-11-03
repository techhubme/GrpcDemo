package com.demo.grpcdemo;

import com.demo.grpcdemo.server.GRPCServer;
import com.demo.grpcdemo.util.CMDLArgumentParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GrpcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcDemoApplication.class, args);
        try {
            /* Parsing the Command line arguments */
            CMDLArgumentParser.parse(args);

            /* Creating, initializing and starting the GRPC server */
            GRPCServer server = new GRPCServer();
            server.initialize();
            server.start();
        } catch (Exception ex) {
            log.error("Exception :)", ex);
        }
    }
}
