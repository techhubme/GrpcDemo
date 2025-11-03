package com.demo.grpcdemo.server;

import com.demo.grpcdemo.config.Constant;
import com.demo.grpcdemo.services.SampleService;
import com.demo.grpcdemo.util.CMDLArgumentParser;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import io.grpc.protobuf.services.ProtoReflectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * The GRPC Server class for GRPC services
 *
 * @author Ram Niwash
 */
@Slf4j
@Component
public class GRPCServer {

    /* PORT_NUMBER of Server */
    private final int portNumber;

    /*GRPC Server */
    private Server server;

    /**
     * Constructor to initialize the server port.
     */
    public GRPCServer() {
        this.portNumber = this.getPortNumber();
    }

    /**
     * Initialize and Starts the GRPC server.
     * The Other option to build the GRPC Server
     * ServerBuilder.forPort(this.portNumber).build();
     */
    public void initialize() {

        this.server = Grpc.newServerBuilderForPort(this.portNumber, InsecureServerCredentials.create())
                .addService(ProtoReflectionService.newInstance())
                /* Add Services here */
                .addService(new SampleService())
                .build();
    }

    /**
     * Start the server
     *
     * @throws IOException          exception
     * @throws InterruptedException exception
     */
    public void start() throws IOException, InterruptedException {
        /* Starting Server */
        this.server.start();
        ServerReadyEvent.onServerReady(this.portNumber);
        this.server.awaitTermination();
    }

    /**
     * Get the server port number
     *
     * @return integer, the port number
     */
    private int getPortNumber() {
        String port;
        try {
            port = CMDLArgumentParser.getArgumentValue(Constant.PORT_ARG);
        } catch (RuntimeException exception) {
            port = System.getenv(Constant.SYSTEM_ENV_GRPC_PORT);
        }
        return parsePortNumber(port);
    }

    /**
     * Parse the Port number from String to integer.
     *
     * @param port String type argument
     * @return int value as port number
     */
    private int parsePortNumber(String port) {
        if (!StringUtil.isNullOrEmpty(port) && port.matches(Constant.PORT_ARG_REGEX)) {
            return Integer.parseInt(port);
        } else {
            return Constant.DEFAULT_GRPC_SERVER_PORT;
        }
    }
}