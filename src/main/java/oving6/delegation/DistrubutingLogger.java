package oving6.delegation;

public class DistrubutingLogger implements ILogger {
  public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
    
  }


  @Override
  public void log(String severity, String message, Exception exception) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'log'");
  }
  
}
