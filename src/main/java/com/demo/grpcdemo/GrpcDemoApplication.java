package com.demo.grpcdemo;

import com.demo.grpcdemo.config.Constant;
import com.demo.grpcdemo.server.GRPCServer;
import com.demo.grpcdemo.util.CMDLArgumentParser;
import com.demo.grpcdemo.util.Emoji;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

/**
 *
 */
@Slf4j
@SpringBootApplication
public class GrpcDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GrpcDemoApplication.class, args);
        try {
            log.info(Constant.LOG_MSG_PATTERN, Emoji.CLI, "Reading Command line arguments");
            /* Parsing the Command line arguments */
            CMDLArgumentParser.parse(args);

            /* Creating, initializing and starting the GRPC server */
            GRPCServer server = ctx.getBean(GRPCServer.class);
            log.info(Constant.LOG_MSG_PATTERN, Emoji.GEAR, "Initializing Server");
            server.initialize();
            log.info(Constant.LOG_MSG_PATTERN, Emoji.LAUNCH, "Starting Server");
            server.start();
        } catch (InterruptedException | IOException ex) {
            log.error(Constant.LOG_MSG_PATTERN, Emoji.ERROR, "Get error while starting server", ex);
            Thread.currentThread().interrupt();
        }
    }
}
