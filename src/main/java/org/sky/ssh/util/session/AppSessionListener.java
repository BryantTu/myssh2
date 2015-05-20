
package org.sky.ssh.util.session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AppSessionListener implements HttpSessionListener {

	private static int activeSessions = 0;
	protected Log logger = LogFactory.getLog(this.getClass());
	/**
	 * set time out
	 */
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = null;
		try {
			session = se.getSession();
			// get value
			ServletContext context = session.getServletContext();
			String timeoutValue = context.getInitParameter("sessionTimeout");
			int timeout = Integer.valueOf(timeoutValue);
			// set value
			session.setMaxInactiveInterval(timeout);
			logger.info("session max inactive interval has been set to "
					+ timeout + " seconds.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		try {
			HttpSession session = se.getSession();
			String userId = "";
			UserSessionInfo userSession = null;
			try {
				userSession = (UserSessionInfo) session
						.getAttribute("UserSessionInfo");
				session.removeAttribute("UserSessionInfo");
			} catch (Exception sex) {
			}
			session.invalidate();
			logger.info("session destroy");
		} catch (Exception e) {

		}
	}

}
