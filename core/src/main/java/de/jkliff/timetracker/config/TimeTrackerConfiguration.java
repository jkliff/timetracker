package de.jkliff.timetracker.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class TimeTrackerConfiguration {

    private int bindPort = 8080;

    public static TimeTrackerConfiguration from(String f)
            throws InvalidConfigurationException {

        Gson g = new Gson();
        try {
            return g.fromJson(new FileReader(new File(f)), TimeTrackerConfiguration.class);
        } catch (JsonSyntaxException e) {
            throw new InvalidConfigurationException("Syntax error.", e);

        } catch (JsonIOException e) {
            throw new InvalidConfigurationException("Gson error.", e);

        } catch (FileNotFoundException e) {
            throw new InvalidConfigurationException("No such configuration file.", e);
        }
    }

    public int getBindPort() {
        return bindPort;
    }

    private void setBindPort(int bindPort) {
        this.bindPort = bindPort;
    }

    public static TimeTrackerConfiguration defaultFallbackConfiguration() {
        TimeTrackerConfiguration ttc = new TimeTrackerConfiguration();
        ttc.setBindPort(8080);

        return ttc;
    }

}
