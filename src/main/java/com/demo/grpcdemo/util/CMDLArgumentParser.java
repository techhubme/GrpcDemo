package com.demo.grpcdemo.util;


import com.demo.grpcdemo.config.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * The Command line argument parser to parse and extract the arguments.
 *
 * @author Ram Niwash
 */
public class CMDLArgumentParser {

    private CMDLArgumentParser(){}

    /* COMMAND_LINE_ARGS constant, Map for Command line arguments */
    private static final Map<String, String> COMMAND_LINE_ARGS = new HashMap<>();

    /**
     * Parse the command line argument and stores into map
     *
     * @param args the command line arguments.
     */
    public static void parse(String[] args) {
        if (args == null) {
            return;
        }
        for (String argument: args) {
            if (argument.startsWith(Constant.COMMAND_ARG_PREFIX)) {
                String[] keyValue = argument.split(Constant.COMMAND_ARG_SPLITER);
                if(keyValue.length == 2) {
                    COMMAND_LINE_ARGS.put(keyValue[0], keyValue[1]);
                }
            }
        }
    }

    /**
     * Return the command line argument by argument key.
     *
     * @param argument the key of command line argument.
     * @return String the value of command line argument.
     */
    public static String getArgumentValue(String argument) {
        if (COMMAND_LINE_ARGS.containsKey(argument)) {
            return COMMAND_LINE_ARGS.get(argument);
        }
        return "";
    }
}