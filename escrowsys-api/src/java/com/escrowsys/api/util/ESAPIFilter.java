/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.api.util;

import com.helper.escrowsys.util.EscrowProperties;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;

/**
 *
 * @author kuuga
 */
public class ESAPIFilter implements Filter{

     private PropertiesConfiguration config = EscrowProperties.getEscrowConfig();

    private static final Logger logger = ESAPI.getLogger( "SwingsetFilter" );

	private static final String[] ignore = { "password" };

	/**
	 * Called by the web container to indicate to a filter that it is being
	 * placed into service. The servlet container calls the init method exactly
	 * once after instantiating the filter. The init method must complete
	 * successfully before the filter is asked to do any filtering work.
	 *
	 * @param filterConfig
	 *            configuration object
	 */
	public void init(FilterConfig filterConfig) {

        String esapidir = config.getString("SAMSUNG.ESAPIPATH", "/apps/ESAPI/resources/");


        System.out.println("from ESAPI : [" + ESAPI.securityConfiguration().getResourceDirectory()  + "]");
        System.out.println("from esapidir : [" + esapidir  + "]");
        if ( ESAPI.securityConfiguration().getResourceDirectory() == null ) {
            System.out.println( "====ESAPI.properties ready to define====");
            ESAPI.securityConfiguration().setResourceDirectory( esapidir);
        }
        else if (!ESAPI.securityConfiguration().getResourceDirectory().equals(esapidir))   {
            System.out.println( "====ESAPI.properties already define but different path ====");
            ESAPI.securityConfiguration().setResourceDirectory(esapidir);
        }
        else    {
            System.out.println( "====ESAPI.properties already define ====");
        }

	}



	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		try {
			// register request and response in ESAPI (usually done through login)
			ESAPI.httpUtilities().setCurrentHTTP(request, response);

			// log this request, obfuscating any parameter named password
			ESAPI.httpUtilities().logHTTPRequest(ESAPI.httpUtilities().getCurrentRequest(), logger, Arrays.asList(ignore));
			// forward this request on to the web application
			chain.doFilter(request, response);
		} catch (Exception e) {

                        //logger.error(Logger.SECURITY, "Error in ESAPI security filter: " + e.getMessage(), e);
			//logger.error( Logger.SECURITY, false,"Error in ESAPI security filter: " + e.getMessage(), e );
			request.setAttribute("message", e.getMessage() );
		} finally {
			// VERY IMPORTANT
			// clear out the ThreadLocal variables in the authenticator
			// some containers could possibly reuse this thread without clearing the User
			ESAPI.authenticator().clearCurrent();
		}



			// register request and response in ESAPI (usually done through login)
        }

	/**
	 * Called by the web container to indicate to a filter that it is being
	 * taken out of service. This method is only called once all threads within
	 * the filter's doFilter method have exited or after a timeout period has
	 * passed. After the web container calls this method, it will not call the
	 * doFilter method again on this instance of the filter.
	 */
	public void destroy() {
		// finalize
	}


}
