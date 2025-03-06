package oving6.delegation;

import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamLogger implements ILogger {
  private PrintWriter writer;
  private String formatString = "%s: %s (%s)";

  public StreamLogger(OutputStream stream) {
    if (stream == null) {
      throw new IllegalArgumentException("Stream cannot be null!");
    }
    this.writer = new PrintWriter(stream, true);
  }

  @Override
  public void log(String severity, String message, Exception exception) {
    String logMessage = String.format(formatString, severity, message, exception);
    writer.println(logMessage);
    writer.flush();
  }
  
  public void setFormatString(String formatString) {
    if (formatString == null) {
      throw new IllegalArgumentException("Cannot be null!");
    }
    this.formatString = formatString;
  }
  
  public static void main(String[] args) {
    ILogger logger = new StreamLogger(System.out);
    logger.log(ILogger.INFO, "Denne mledningen er til informasjon og skrices til System.out", null);
  }
}
