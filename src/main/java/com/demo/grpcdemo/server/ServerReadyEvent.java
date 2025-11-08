package com.demo.grpcdemo.server;

import com.demo.grpcdemo.config.Constant;
import com.demo.grpcdemo.util.LineWrapper;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * The startup code that run after application server startup
 *
 * @author Ram Niwash
 */
@Slf4j
public class ServerReadyEvent {

    private ServerReadyEvent() {
    }

    /**
     * Logs the Server URL (IP and Port number) for reference.
     *
     * @param portNumber the port number of server
     */
    public static void onServerReady(int portNumber) {
        List<String> lines = new ArrayList<>();
        lines.add(Constant.WELCOME_MESSAGE);
        try {
            Enumeration<NetworkInterface> enumerationNW = NetworkInterface.getNetworkInterfaces();
            while (enumerationNW.hasMoreElements()) {
                NetworkInterface networkInterface = enumerationNW.nextElement();
                Enumeration<InetAddress> enumeration = networkInterface.getInetAddresses();
                while (enumeration.hasMoreElements()) {
                    StringBuilder line = new StringBuilder();
                    InetAddress inetAddress = enumeration.nextElement();
                    String hostAddress = inetAddress.getHostAddress();
                    if (hostAddress.matches(Constant.IP_REGEX)) {
                        line.append(Constant.HOST).append(Constant.ONE_SPACE)
                                .append(Constant.COLON).append(Constant.ONE_SPACE).append(hostAddress)
                                .append(Constant.COLON).append(portNumber);

                        lines.add(line.toString());
                    }
                }
            }
            String hostText = LineWrapper.wrapInBorder(lines, Boolean.TRUE);
            log.info(hostText);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}