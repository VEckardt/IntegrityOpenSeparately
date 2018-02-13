/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uitools;

import uitools.api.IntegrityCommands;

/**
 *
 * @author exde32e1
 */
public class UITools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //  IF "%MKSSI_DOCUMENT%"=="" 
        // (im viewsegment --user=%MKSSI_USER% --gui %MKSSI_ISSUE0%) 
        // ELSE 
        // (im viewsegment --user=%MKSSI_USER% --gui %MKSSI_DOCUMENT%)  
        IntegrityCommands ic = new IntegrityCommands();

        String documentID = System.getenv("MKSSI_DOCUMENT") + "";
        ic.log("documentId: " + documentID, 2);

        String issue0 = System.getenv("MKSSI_ISSUE0") + "";
        ic.log("issue0: " + issue0, 2);

        for (int i = 0; i < args.length; i++) {
            ic.log("Parameter: " + args[i], 2);
        }

        if (args.length < 1) {
            ic.openSeparately(documentID, issue0, "now");
        } else if (args[0].contentEquals("asOf")) {
            ic.openSeparately(documentID, issue0, "asOf");
        } else {
            ic.openSeparately(documentID, issue0, "now");
        }

    }

}
