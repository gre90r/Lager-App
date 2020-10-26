package de.gre90r.LagerApp.util;

import org.slf4j.LoggerFactory;

public class LoggerImpl implements de.gre90r.LagerApp.util.Logger {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoggerImpl.class.getName());

  @Override
  public void logInfo(String s) {
    logger.info(s);
  }

  @Override
  public void logWarning(String s) {
    logger.warn(s);
  }

  @Override
  public void logError(String s) {
    logger.error(s);
  }
}
