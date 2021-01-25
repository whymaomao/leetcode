package com.yue;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nioFileOperate {

    private final static String FILE_URL = "xm-local-build/XMS/BugFixRP/BF_Rel_RP_RP2_XII_10.12.0/10.12.0.18/artifacts/onprem/xms_10.12.0.10218.bin";
    private final static String FILE_PATH = "/Users/huyue/JavaCodeRepo/leetcode/src/com/yue/xms_10.12.0.10218.bin";
    // nio2 framework to delete file
    public static void main(String[] args) {

        downloadFileNIO(FILE_URL, FILE_PATH);
    }



    public static String match(String glob, String location) throws IOException {
        StringBuilder result = new StringBuilder();
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
        Files.walkFileTree(Paths.get(location), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                System.out.println("I'm visiting the file " + path + " which has the size " + attrs.size());
                if (pathMatcher.matches(path)) {
                    result.append(path.toString());
                    return FileVisitResult.TERMINATE;
                }
                else
                {
                    System.out.println("not found");
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return result.toString();
    }

    public static void downloadFileBufferIO(String filePath, String fileUrl)
    {
        long startTime = System.nanoTime();
        try(BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }

        }
        catch(IOException e){

        }
        long endTime = System.nanoTime();
        System.out.println("Running time is " + (endTime - startTime)/1000000);
    }



    public static void downloadFileNIO(String buildPath, String filePath)
    {
        Pattern pattern = Pattern.compile("xm-local-build/XMS.*/artifacts/onprem.*");
        Matcher matcher = pattern.matcher(buildPath);
        if(matcher.matches()) {
            String maiRepoPrefix = "https://mia-repo.citrite.net/";
            System.out.println("downloading from jfrog");
            long startTime = System.nanoTime();
            URL url = null;
            ReadableByteChannel readableByteChannel = null;
            FileOutputStream fileOutputStream = null;

            Path path = Paths.get(filePath);
            try{
                url = new URL(maiRepoPrefix + buildPath);
                readableByteChannel = Channels.newChannel(url.openStream());
                fileOutputStream = new FileOutputStream(filePath);

                fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                System.out.println("! File successfully downloaded from the url !");

                boolean fileExists = Files.exists(path);
                if(fileExists)
                {
                    HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
                    httpConnection.setRequestMethod("HEAD");
                    long remoteFileSize = httpConnection.getContentLengthLong();
                    System.out.println("remoteFileSize is " + remoteFileSize);
                    long exisitingFileSize = Files.size(Paths.get(filePath));
                    System.out.println("existingFileSize is " + exisitingFileSize );
                    if(exisitingFileSize < remoteFileSize){
                        System.out.println("Error when downloading file, size is not right");
                    }
                }

            }catch(IOException ioException)
            {
                System.out.println("Problem Occured while downloading the file = ");
            }finally{
                try{
                    if(fileOutputStream != null) fileOutputStream.close();
                    if(readableByteChannel != null) readableByteChannel.close();
                }catch(IOException e)
                {
                    System.out.println("Problem Occured while downloading the file = ");
                }
            }
            long endTime = System.nanoTime();
            System.out.println("Running time is " + (endTime - startTime)/(1000000*60000));
        }else
        {
            System.out.println("download path is wrong " + buildPath);
//            throw new Exception("download path is wrong " + buildPath);
        }
    }


}
