package org.capturecoop.ccutils.utils;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LinkUtils {
    public static URI getURI(String link) {
        try {
            return new URI(link);
        } catch (URISyntaxException exception) {
            //TODO: Once logger is done uncomment this
            //CCLogger.log("Could not get URI!", LogLevel.ERROR);
            //CCLogger.logStacktrace(exception, LogLevel.ERROR);
        }
        return null;
    }

    public static void openLink(String link) {
        try {
            Desktop.getDesktop().browse(getURI(link));
        } catch (IOException exception) {
            //TODO: Once logger is done uncomment this
            //CCLogger.log("Could open link!", LogLevel.ERROR);
            //CCLogger.logStacktrace(exception, LogLevel.ERROR);
        }
    }
}
