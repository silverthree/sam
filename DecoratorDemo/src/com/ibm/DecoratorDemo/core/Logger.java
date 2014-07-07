package com.ibm.DecoratorDemo.core;


/**
 * Simple Logger utility to log information
 */ 

import org.eclipse.core.runtime.Status;

public class Logger
{
  public static void logError(String message, Throwable throwable)
  {
    DecoratorPlugin.getDefault().getLog().log(
      new DemoStatus(Status.ERROR, message, throwable));
  }
  
  public static void logError(Throwable throwable)
  {
    DecoratorPlugin.getDefault().getLog().log(
      new DemoStatus(Status.ERROR, throwable.getMessage(), throwable));
  }  
  
  public static void logInfo(String message)
  {
    DecoratorPlugin.getDefault().getLog().log(
      new DemoStatus(Status.INFO, message));
  }  
}
