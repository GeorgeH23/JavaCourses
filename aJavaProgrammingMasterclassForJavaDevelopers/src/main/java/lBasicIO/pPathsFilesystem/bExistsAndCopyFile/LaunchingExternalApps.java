package lBasicIO.pPathsFilesystem.bExistsAndCopyFile;

import java.io.IOException;

public class LaunchingExternalApps {
    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        String[] s = {"C:\\Program Files (x86)\\Windows Media Player\\wmplayer.exe", "C:\\Users\\gharpa\\Desktop\\CognexCameraBackupProcedure.mp4"};

        try
        {
            //runtime.exec("/Users/gharpa/AppData/Local/StreamingVideoProvider/ScreenRec_app/screenrec.exe");        //opens new notepad instance
            runtime.exec(s);

            //OR runtime.exec("notepad");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
