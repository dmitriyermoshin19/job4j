package ru.job4j.oo3.sql;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Проверка подключения логера log4j
 */
public class UsageLog4j2 {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
