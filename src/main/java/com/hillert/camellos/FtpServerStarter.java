package com.hillert.camellos;

import org.apache.ftpserver.FtpServer;
import org.slf4j.Logger;
import org.springframework.beans.factory.DisposableBean;

/**
 * Little Helper Bean, by default the embedded FTP won't start automatically
 * and the cleanest way to tart it through the Spring context is by creating
 * a custom bean that implements the DisposableBean interface and starts 
 * the server at bean initialization.
 * 
 * @author Gunnar Hillert
 * @version 1.0
 *
 */
public class FtpServerStarter implements DisposableBean {

	/** Logger declaration */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(FtpServerStarter.class);
	
	/** The Ftp server to start and stop */
	private FtpServer server;

	/** Default constructor */
	private FtpServerStarter() {
		super();
	}

	/** Sets the FtpServer instance and starts the Ftp server */
	public void setFTPServer(FtpServer server) {
		this.server = server;
		init();
	}

	private void init() {
		try {
			server.start();
		} catch (Exception e) {
			throw new IllegalStateException("Unable to start the server.", e);
		}
	}

	/** Called when the Spring Application Context is being shutdown. Shuts
	 *  down the Ftp Server. */
	@Override
	public void destroy() throws Exception {	
		server.stop();
		LOGGER.info("stopped Ftp server.");
	}

}
