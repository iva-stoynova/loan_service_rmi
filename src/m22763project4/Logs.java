/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package m22763project4;

import java.io.*;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Iwa Stojnowa
 */
public class Logs
{
    // private data
    private FileWriter fwriter;
    private JTextArea serverLog;
    private static final String LOG_FILE = "logfile";
    private static final String BUNDLE = "m22763project4.resources.configuration";
    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle(BUNDLE);

    // constructor
    public Logs(JTextArea aConsole)
    {
        serverLog = aConsole;
        try
        {
            fwriter = new FileWriter(Logs.getString(LOG_FILE), true);
        } 
        catch (IOException e) // catch IO exception
        {
            serverLog.append("Error in opening log file: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    // getString method to get key from resources.configuration
    public static String getString(String key)
    {
        try
        {
            return RESOURCE.getString(key);
        }
        catch (MissingResourceException e)
        {
            Logger.getLogger(Logs.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Can not find property for key: " + key);
            e.printStackTrace();
            return null;
        }
    }

    // wirte message to log
    public void log(String aMessage)
    {
        serverLog.append(aMessage + "\n");
        try
        {
            fwriter.write(aMessage + "\n");
            fwriter.flush();
        } 
        catch (IOException ex)
        {
            serverLog.append("Can not write to log file: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }
    // close file
    public void close()
    {
        try
        {
            if (fwriter != null)
            {
                fwriter.close();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
