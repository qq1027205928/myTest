package com.testparam.controller;

import java.io.File;

public class LibreOffice {
    public static boolean wordConverterToPdf(String filepath,String pdfpath) throws Exception {
        File file = new File(filepath);
        String path = pdfpath;
        System.out.println("filepath++++++++++++++++++++++"+filepath);
        System.out.println("path++++++++++++++++++++++"+path);
        try {
            String osName = System.getProperty("os.name");
            String command = "";
            if (osName.contains("Windows")) {
                command = "soffice --convert-to pdf  -outdir " + path +" "+ filepath;
                System.out.println("command1++++++++++++++++++++++"+command);
            } else {
                //command = "doc2pdf --output=" + path + File.separator + file.getName().replaceAll(".(?i)docx", ".pdf") + " " + filepath;
                command = "soffice --headless --invisible --convert-to pdf "+filepath +" --outdir "+ pdfpath;
                System.out.println("command2++++++++++++++++++++++"+command);
            }
            String result = CommandExecute.executeCommand(command);
            if (result.equals("") || result.contains("writer_pdf_Export")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }

}
