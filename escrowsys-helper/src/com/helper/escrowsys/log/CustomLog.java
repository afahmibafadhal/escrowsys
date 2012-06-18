/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.helper.escrowsys.log;

import java.util.Hashtable;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 *
 * @author kuuga
 */
public class CustomLog implements LoggerFactory{

     private static Hashtable<String, escrowLog> loggers = new Hashtable<String, escrowLog>();

    public Logger makeNewLoggerInstance(String name) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(escrowLog.class.getClassLoader());//wherethe class returned is one from your plugin.
        escrowLog result = loggers.get(name);
        if (result == null) {
            result = new escrowLog(name, null);
        }
        Thread.currentThread().setContextClassLoader(cl);//set classloader back
        return result;
    }

}


