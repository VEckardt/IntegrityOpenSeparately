/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uitools;

/**
 *
 * @author veckardt
 */
public class Copyright {

    public static final String COPYRIGHT = "(c)";
    public static final String copyright = "Copyright " + COPYRIGHT + " 2015 PTC Inc.";
    public static final String copyrightHtml = "Copyright &copy; 2015 PTC Inc.";
    public static final String programName = "Integrity - UI Tools";
    public static final String programShortName = "IntegrityUITools";
    public static final String programVersion = "1.0";
    public static final String author = "Author: Volker Eckardt";
    public static final String email = "email: veckardt@ptc.com";
    public static final String title = programName+" - v"+programVersion;

    public static String getCopyright () {
        String copy = ("* " + programName + " - Version " + programVersion);
        copy = copy + ("\n* An utility to open documents and items separtely");
        copy = copy + ("\n* Tested with Integrity 10.6");
        copy = copy + ("\n*");
        copy = copy + ("\n* " + copyright);
        copy = copy + ("\n* " + author + ", " + email + "\n");   
        return copy;
    }
    
    public static void write() {
        System.out.println(getCopyright());
    }

    public static void usage() {
        System.out.println("*");
        System.out.println("* Usage: ");
        System.out.println("*   <path-to-javaw>\\javaw -jar <path-to-jar>\\IntegrityUndo.jar");
        System.out.println("* Example:");
        System.out.println("*   C:\\Program Files\\Java\\jdk1.7.0_21\\bin\\javaw -jar C:\\IntegrityClient10\\IntegrityTraceTool.jar");
        System.out.println("* Additional Notes:");
        System.out.println("*   - a configuration file 'IntegrityUndo.properties' can be used to specify default values");
        System.out.println("*   - a log file is created in directory '%temp%', the filename is 'IntegrityTraceTool_YYYY-MM-DD.log'");
        System.out.println("*");
    }
}
