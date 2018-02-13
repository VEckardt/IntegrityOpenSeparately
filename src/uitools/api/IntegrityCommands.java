/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uitools.api;

import com.mks.api.Command;
import com.mks.api.Option;
import com.mks.api.response.APIException;
import com.mks.api.response.Response;
import com.ptc.services.common.api.IntegrityAPI;
import com.ptc.services.common.tools.EnvUtil;
import static java.lang.System.out;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import uitools.Copyright;
import uitools.UITools;

/**
 *
 * @author exde32e1
 */
public class IntegrityCommands extends IntegrityAPI {

    public static Map<String, String> env = System.getenv();
    private boolean debugFlag = false;
    String userID = System.getenv("MKSSI_USER") + "";
    String host = System.getenv("MKSSI_HOST") + "";
    String port = System.getenv("MKSSI_PORT") + "";
    // MKSSI_WINDOW=DocumentView
    String window = System.getenv("MKSSI_WINDOW").toLowerCase() + "";

    // IF "%MKSSI_DOCUMENT%"=="" (im viewsegment --user=%MKSSI_USER% --gui %MKSSI_ISSUE0%) ELSE (im viewsegment --user=%MKSSI_USER% --gui %MKSSI_DOCUMENT%)  
    public IntegrityCommands() {
        super(env, Copyright.programShortName);
    }

    // 
    // set now="%date% %time:~0,-3%"
    // im viewsegment --hostname=%MKSSI_HOST% --port=%MKSSI_PORT% --user=%MKSSI_USER% --asOf=%now% --gui %MKSSI_DOCUMENT%
    public void openSeparately(String docID, String issueID, String mode) {

        docID = docID.replace("null", "");
        issueID = issueID.replace("null", "");

        String listOfColumns = EnvUtil.getListOfColumnsWithWidth();

        log("listOfColumns: " + listOfColumns, 2);

        Command cmd = new Command(Command.IM, "viewsegment");
        cmd.addOption(new Option("gui"));
        if (window.contentEquals("documentview") && !listOfColumns.isEmpty()) {
            cmd.addOption(new Option("fields", listOfColumns));
        }
        // --focusIssueID=value
        if (mode.contentEquals("asOf")) {
            DateFormat dfDayTimeShortUS = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.US);

            // DateFormat dfDayTimeShort = new SimpleDateFormat ("MMM d, yyyy h:mm:ss a", Locale.US);
            log(dfDayTimeShortUS.format(new Date()));
            cmd.addOption(new Option("asOf", dfDayTimeShortUS.format(new Date())));
        }

        cmd.addSelection(issueID.isEmpty() ? docID : issueID);
        // cmd.addSelection(issueID);
        try {
            Response response = this.executeCmd(cmd);
        } catch (APIException ex) {
            Logger.getLogger(UITools.class.getName()).log(Level.SEVERE, null, ex);
            log("ERROR: " + ex.getMessage());
        }
    }

    void log(String text) {
        out.println(text);
        super.log(text, 1);
    }
}
