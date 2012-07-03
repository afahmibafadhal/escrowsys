/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.helper.escrowsys.util;


import java.io.File;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
/**
 *
 * @author kuuga
 */
public class EscrowProperties {

    private static final String ESCROW_SYSTEM_PROPERTIES = "/apps/escrow/properties/escrowConfig.properties";
    private static final String ESCROW_SQL_QUERIES_PROPERTIES = "/apps/escrow/properties/escrowSQL.properties";
    private static final String ESCROW_GUI_PROPERTIES = "/apps/escrow/properties/escrowGUI.properties";
    public static final String ESCROW_ACTIVITY_LOG_PROPERTIES = "/apps/escrow/properties/escrowActivityLog.properties";
    private static transient PropertiesConfiguration escrowConfig = null;
    private static transient PropertiesConfiguration escrowSQLConfig = null;
    private static transient PropertiesConfiguration escrowGUIConfig = null;
    private static transient PropertiesConfiguration escrowActivityLogConfig = null;
    static final Object LOCK4 = new Object();
    static final Object LOCK5 = new Object();
    static final Object LOCK6 = new Object();
    static final Object LOCK7 = new Object();

    public static PropertiesConfiguration createConfigFile(String file, boolean disableDelimiter) {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration();
            config.setDelimiterParsingDisabled(disableDelimiter);
            File f = new File(file);
            config.load(file);
            config.setReloadingStrategy(new FileChangedReloadingStrategy());
            return config;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }

    }

    public static PropertiesConfiguration getEscrowConfig() {
        synchronized (LOCK4) {
            if (escrowConfig == null) {
                escrowConfig = createConfigFile(ESCROW_SYSTEM_PROPERTIES, false);
            }
        }
        return escrowConfig;
    }

    public static PropertiesConfiguration getEscrowSQLConfig() {
        synchronized (LOCK5) {
            if (escrowSQLConfig == null) {
                escrowSQLConfig = createConfigFile(ESCROW_SQL_QUERIES_PROPERTIES, true);
            }
        }
        return escrowSQLConfig;
    }

    public static PropertiesConfiguration getSamsungGUIConfig() {
        synchronized (LOCK6) {
            if (escrowGUIConfig == null) {
                escrowGUIConfig = createConfigFile(ESCROW_GUI_PROPERTIES, true);
            }
        }
        return escrowGUIConfig;
    }

    public static PropertiesConfiguration getSamsungBoActivityLogConfig() {
        synchronized (LOCK7) {
            if (escrowActivityLogConfig == null) {
                escrowActivityLogConfig = createConfigFile(ESCROW_ACTIVITY_LOG_PROPERTIES, true);
            }
        }
        return escrowActivityLogConfig;
    }

}
