package avh.nuversity.lms.services.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//import avh.nuversity.digid.services.impl.FileStorageProperties;

@Service
public class FileStorageService {

    private Path fileStorageLocation;
    @Autowired
    public FileStorageService(){
    }

    public String storeFile(MultipartFile file,String path) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path fileStorageLocation = Paths.get(path)
                .toAbsolutePath().normalize();
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    	
    }


	}

