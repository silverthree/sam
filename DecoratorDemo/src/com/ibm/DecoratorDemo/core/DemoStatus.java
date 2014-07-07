package com.ibm.DecoratorDemo.core;

import org.eclipse.core.runtime.Status;

public class DemoStatus extends Status
{
  public DemoStatus(
    int type,
    int code,
    String message,
    Throwable exception)
  {
    super(type, "hello", code, message, exception);
  }
  
  public DemoStatus(int code, String message)
  {
    this(code, code, message, null);
  }
  
  public DemoStatus(int code, String message, Throwable exception)
  {
    this(code, code, message, exception);
  }
}
