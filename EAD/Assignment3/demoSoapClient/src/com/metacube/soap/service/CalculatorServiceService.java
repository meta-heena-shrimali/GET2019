/**
 * CalculatorServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.soap.service;

public interface CalculatorServiceService extends javax.xml.rpc.Service {
    public java.lang.String getCalculatorServiceAddress();

    public com.metacube.soap.service.CalculatorService getCalculatorService() throws javax.xml.rpc.ServiceException;

    public com.metacube.soap.service.CalculatorService getCalculatorService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
