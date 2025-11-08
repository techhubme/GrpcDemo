package com.demo.grpcdemo.config;

/**
 * Constants defined for reusability.
 *
 * @author Ram Niwash
 */
public final class Constant {

    private Constant(){}

    /* The WELCOME_MSG Constant */
    public static final String WELCOME_MESSAGE = "WELCOME TO GRPC-Demo Application";

    /* The NEW_LINE Constant */
    public static final String NEW_LINE = "\n";

    /* The HOST Constant */
    public static final String HOST = "HOST";

    /* The ONE_SPACE Constant */
    public static final String ONE_SPACE = " ";

    /* The COLON Constant */
    public static final String COLON = ":";

    /* COMMAND_ARG_PREFIX constant */
    public static final String COMMAND_ARG_PREFIX = "-";

    /* COMMAND_ARG_SPLITER constant */
    public static final String COMMAND_ARG_SPLITER = ":";

    /* PORT constant */
    public static final String PORT_ARG = "-port";

    /* PORT_REGEX constant */
    public static final String PORT_ARG_REGEX = "[0-9]{4}";

    /* IP_REGEX constant */
    public static final String IP_REGEX = "[0-9.]+";

    /* Defines the environment variable name for GRPC Server port number */
    public static final String SYSTEM_ENV_GRPC_PORT = "GRPC_SERVER_PORT";

    /* LOG_MSG_PATTERN */
    public static final String LOG_MSG_PATTERN = "[ {} ] : {}";

    /**
     * Number constants declaration
     */
    /* The Default Port number of Server */
    public static final int DEFAULT_GRPC_SERVER_PORT = 9080;
}
