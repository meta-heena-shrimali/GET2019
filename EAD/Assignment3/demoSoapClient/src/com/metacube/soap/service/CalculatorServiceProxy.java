package com.metacube.soap.service;

public class CalculatorServiceProxy implements com.metacube.soap.service.CalculatorService {
  private String _endpoint = null;
  private com.metacube.soap.service.CalculatorService calculatorService = null;
  
  public CalculatorServiceProxy() {
    _initCalculatorServiceProxy();
  }
  
  public CalculatorServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculatorServiceProxy();
  }
  
  private void _initCalculatorServiceProxy() {
    try {
      calculatorService = (new com.metacube.soap.service.CalculatorServiceServiceLocator()).getCalculatorService();
      if (calculatorService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculatorService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculatorService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculatorService != null)
      ((javax.xml.rpc.Stub)calculatorService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.soap.service.CalculatorService getCalculatorService() {
    if (calculatorService == null)
      _initCalculatorServiceProxy();
    return calculatorService;
  }
  
  public double getArea(double side1, double side2, double side3) throws java.rmi.RemoteException{
    if (calculatorService == null)
      _initCalculatorServiceProxy();
    return calculatorService.getArea(side1, side2, side3);
  }
  
  
}