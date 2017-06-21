

import DownloadPackage.*;

public class MainClass {
    public static void main(String[] args) {
        String CSVfilename;
        String filedir;
        int downloaded = 0;
        StringBuilder notDownloaded = new StringBuilder();
        if (args.length != 2) {
            System.out.println("Wrong number of arguments.\n !Notice: Filename Directory");
            System.exit(0);
        }
        CSVfilename = args[0];
        filedir = args[1];
        System.out.println("CSV file name: " + CSVfilename);
        System.out.println("Directory: " + filedir);
        System.out.println();

        ReadCSV csvChannel = new ReadCSV();
        FileList fileList = csvChannel.read(CSVfilename);
        csvChannel.getCSVstatus();
        if (csvChannel.isRead()) {
            int size = fileList.size();
            DownloadFile downloadFile = new DownloadFile();
            for (int i = 0; i < size; i++) {
                downloadFile.downloadFile(fileList.get(i), filedir);
                //System.out.println(downloadFile.getFileStatus());
                if (downloadFile.isFileDownloaded()) downloaded++;
                else notDownloaded.append("\n" + downloadFile.getFileStatus() + "\n\n");
            }
            System.out.println("\n\n___FINAL___\n" + "DOWNLOADED : " + downloaded + " files\n" + "NOT DOWNLOADED : " + (size - downloaded) + " files\n" + notDownloaded);
        }


    }
}
