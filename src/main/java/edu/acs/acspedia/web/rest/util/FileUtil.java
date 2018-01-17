package edu.acs.acspedia.web.rest.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class FileUtil {

    public static boolean saveFileToDisk(MultipartFile file, String path) {
        try {
            createDirectoryIfNotExists(path);
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
            return true;
        } catch (IOException ioe) {
            log.println(ioe);
            return false;
        }
    }

    public static void downloadFile(HttpServletResponse response, String path) {
        try {
            FileInputStream stream = new FileInputStream(new File(path));
            String extension = FilenameUtils.getExtension(path);
            if ("txt".equalsIgnoreCase(extension)) {
                response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            } else if ("pdf".equalsIgnoreCase(extension)) {
                response.setContentType("application/pdf");
            } else if ("txt".equalsIgnoreCase(extension)) {
                response.setContentType("plain/txt");
            } else {
                response.setContentType("application/octet-stream");
            }
            response.setHeader("Content-disposition", "attachment; filename=" + path.substring(path.lastIndexOf('/')));
            IOUtils.copy(stream, response.getOutputStream());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createDirectoryIfNotExists(String filePath) {
        String directoryName = filePath.substring(0, filePath.lastIndexOf('/'));

        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}

