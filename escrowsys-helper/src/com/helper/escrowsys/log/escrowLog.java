/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.helper.escrowsys.log;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

/**
 *
 * @author kuuga
 */
public class escrowLog extends Logger{

     public escrowLog(String name) {
        super(name);
    }

    public escrowLog(String name, String resourceBundle) {
        super(name);
    }

    private static CustomLog myFactory = new CustomLog();

    public static synchronized escrowLog getLogger(String name) {
        return (escrowLog) Logger.getLogger("Escrowsys-"+name, myFactory);
    }

    public String preparePrefix(Object p, String msg) {
        try {
            String s = null;
            if (p instanceof CustomMessage) {
                CustomMessage u = (CustomMessage) p;
                s = escrowLog.class.getName() + "-"+ u.getSomeHeader() + "-" + u.getSomeMessage();
            } /*else if (p instanceof AdminActivityLog){
                AdminActivityLog u=(AdminActivityLog)p;
                s=u.getAdminUsers().getLoginId()+"-"+u.getRefNum();
            }else if(p instanceof CustomerActivityLog){
                CustomerActivityLog u=(CustomerActivityLog)p;
                s=u.getCustomer().getLoginId()+"-"+u.getRefNum();
            }*/
            else if (p == null) {
                s = "";
            } else {
                s = p.toString();
            }
            return String.format("[%s]%s", s, msg);
        } catch (Throwable ex) {
            ex.printStackTrace();
            return "";
        }

    }


    public String getFormattedString(String msg, Object input, Object... args) {
        return String.format(preparePrefix(input, msg), args);
    }


    public String getFormattedString(String msg, Object... args) {
        return String.format(msg, args);
    }

    public void config(String msg, Object... args) {
        if (isInfoEnabled()) {
            log(Level.INFO, getFormattedString(msg, args));
        }
    }

    public void config(Object prefixInfo, String msg, Object... args) {
        if (isInfoEnabled()) {
            log(Level.INFO, getFormattedString(msg, prefixInfo, args));
        }
    }

    public void fine(String msg, Object... args) {
        if (isDebugEnabled()) {
            log(Level.DEBUG, getFormattedString(msg, args));
        }

    }

    public void fine(Object prefixInfo, String msg, Object... args) {
        if (isDebugEnabled()) {
            log(Level.DEBUG, getFormattedString(msg, prefixInfo, args));
        }

    }

    public void finer(Object prefixInfo, String msg, Object... args) {
        if (isDebugEnabled()) {
            log(Level.DEBUG, getFormattedString(msg, prefixInfo, args));
        }
    }

    public void finest(String msg, Object... args) {
        if (isDebugEnabled()) {
            log(Level.DEBUG, getFormattedString(msg, args));
        }
    }

    public void finest(Object prefixInfo, String msg, Object... args) {
        if (isDebugEnabled()) {
            log(Level.DEBUG, getFormattedString(msg, prefixInfo, args));
        }
    }

    public void severe(String msg, Object... args) {
        log(Level.ERROR, getFormattedString(msg, args));
    }

    public void severe(Throwable th, String msg, Object... args) {
        log(Level.ERROR, getFormattedString(msg, args), th);
    }

    public void severe(Object prefixInfo, Throwable th, String msg, Object... args) {
        log(Level.ERROR, getFormattedString(msg, prefixInfo, args), th);
    }

    public void severe(Object prefixInfo, String msg, Object... args) {
        log(Level.ERROR, getFormattedString(msg, prefixInfo, args));
    }


    public void info(Throwable th, String msg, Object... args) {
        if (isInfoEnabled()) {
            log(Level.INFO, getFormattedString(msg, args), th);
        }
    }

    public void info(String msg) {
        if (isInfoEnabled()) {
            log(Level.INFO, msg);
        }
    }

    public void sInfo(String msg, Object... args) {
        if (isInfoEnabled()) {
            log(Level.INFO, getFormattedString(msg, args));
        }
    }

    public void info(Object prefixInfo, Throwable th, String msg, Object... args) {
        if (isInfoEnabled()) {
            log(Level.INFO, getFormattedString(msg, prefixInfo, args), th);
        }
    }

    public void info(Object prefixInfo, String msg, Object... args) {
        if (isInfoEnabled()) {
            log(Level.INFO, getFormattedString(msg, prefixInfo, args));
        }
    }


    public void warning(Throwable th, String msg, Object... args) {

        log(Level.WARN, getFormattedString(msg, args), th);
    }

    public void warn(String msg) {
        log(Level.WARN, msg);
    }

    public void warning(String msg, Object... args) {

        log(Level.WARN, getFormattedString(msg, args));
    }

    @Override
    public void setLevel(Level newLevel) throws SecurityException {
        super.setLevel(newLevel);
    }

    public void debug(String msg, Object... args) {
        if (isDebugEnabled()) {
            log(Level.DEBUG, getFormattedString(msg, args));
        }
    }

    public void debug(Object prefixInfo, String msg, Object... args) {
        if (isDebugEnabled()) {
            log(Level.DEBUG, getFormattedString(msg, prefixInfo, args));
        }
    }

}
