import java.io.*;
import java.util.Date;

public class LogToFileLAVAISHN {
    File file;
    PrintWriter pw;
    BufferedWriter bw;
    String path;
    public LogToFileLAVAISHN(String path) {
        this.path = path;
        String date = (new Date()).toString();
        file = new File(path + date + ".log");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bw = new BufferedWriter(fw);
        log("CallLog Created\n\n");
    }
    public LogToFileLAVAISHN(String filename, boolean defaultPath) {
        if(defaultPath) {
            this.path = "/Users/lavaishn/appd/APM_Plat/LAVAISHN_Agent_Log/" + filename;
            String date = (new Date()).toString();
            file = new File(path + date + ".log");
            FileWriter fw = null;
            try {
                fw = new FileWriter(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bw = new BufferedWriter(fw);
            log("CallLog Created\n\n");
        }
    }
    public void refreshlogger() {
        //closing already open streams
        try {
            bw.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // creating new logger file.
        String date = (new Date()).toString();
        file = new File(path + date + ".log");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bw = new BufferedWriter(fw);
        log("CallLog Created\n\n");
        System.out.println(Thread.currentThread().getStackTrace());
    }
    public void log(String message){
        pw = new PrintWriter(bw);
        pw.println(message);
        pw.flush();
    }
    public void logWithThreadName(String message){
        pw = new PrintWriter(bw);
        String threadId = String.valueOf(Thread.currentThread().getId());
        pw.println("Thread " + threadId + " " + (new Date()).toString() + "  " + message);
        pw.flush();
    }
    public static void main(String[] args) {
        //        private final loggtofileLAVAISHN templogger = new loggtofileLAVAISHN("/Users/lavaishn/appd/APM_Plat/LAVAISHN_Log/controller.log");
    }
}
