package com.geekbrains.io;

import java.io.*;

public class IoIntro {

    public static final String APP_NAME = "server/";
    private static final byte[] buffer = new byte[1024];
    private static final String ROOT_DIR = "server/root/";

    public static void main(String[] args) throws IOException {
        IoIntro intro = new IoIntro();
        System.out.println(intro.readAsString());
        intro.createServerDir();
        intro.transfer(
                new File("D:\\JDai\\Java.Уровень 4\\server\\src\\main\\resources\\com\\geekbrains\\io\\hello.txt"),
                new File(ROOT_DIR + "copy.txt")
        );
    }

    private void createServerDir(){
        File dir = new File(APP_NAME + "root");
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    private String readAsString() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("hello.txt");
        int read = 0;
        if (inputStream != null) {
            read = inputStream.read(buffer);
        }
        return new String(buffer,0,read);
    }

    private void transfer(File src, File dst) {
        try (FileInputStream is = new FileInputStream(src);
             FileOutputStream os = new FileOutputStream(dst)
        ) {
            int read;
            while ((read = is.read(buffer)) != -1) {
                os.write(buffer, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
