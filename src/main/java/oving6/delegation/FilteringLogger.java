package oving6.delegation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FilteringLogger implements ILogger {
  private final ILogger logger;
  private final Set<String> activeSeverities;

  public FilteringLogger(ILogger logger, String... severities) {
    this.logger = logger;
    this.activeSeverities = new HashSet<>();
    this.activeSeverities.addAll(Arrays.asList(severities));
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    if (activeSeverities.contains(severity)) {
      logger.log(severity, message, exception);
    }
  }
  
  public boolean isLogging(String severity) {
    return activeSeverities.contains(severity);
  }

  public void setIsLogging(String severity, boolean value) {
    if (value) {
      activeSeverities.add(severity);
    }
    else {
      activeSeverities.remove(severity);
    }
  }
}
