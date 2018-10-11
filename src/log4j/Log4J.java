/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import util.Server;
 
/**
 *
 * @author Matheus
 */
public class Log4J {
 
//initializing the logger
static Logger log = Logger.getLogger(Log4J.class.getName());
static Server server;
/**
 * @param args the command line arguments
 */
 public static void main(String[] args) {
  log.setLevel(Level.ERROR);
 //logging in different levels
 log.trace("This is a Trace");
 log.debug("This is a Debug");
 log.info("This is an Info");
 log.warn("This is a Warn");
 log.error("This is an Error");
 log.fatal("This is a Fatal");
 
 }
 
 public static Server getServer()
 {
     if( server == null )
     {
         server = new Server();
         server.start();
     }
     return server;
 }
}