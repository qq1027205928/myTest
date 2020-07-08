package com.testparam.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandExecute {
    public static String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        int data =0;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        try {
            System.out.println(command);
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            inputStreamReader = new InputStreamReader(p.getInputStream(), "UTF-8");
            reader = new BufferedReader(inputStreamReader);

            while((data = inputStreamReader.read())!=-1){
                System.out.println((byte)data);
            }
            InputStream isErr = p.getErrorStream();
            data =0;
            while((data = isErr.read())!=-1){
                System.out.println((byte)data);
            }

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(inputStreamReader);
        }
        System.out.println(output.toString());
        return output.toString();

    }

}
