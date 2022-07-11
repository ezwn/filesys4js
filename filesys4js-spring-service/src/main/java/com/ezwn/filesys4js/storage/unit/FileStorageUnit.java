package com.ezwn.filesys4js.storage.unit;

import com.ezwn.filesys4js.model.FS4JSFile;
import lombok.Getter;
import org.springframework.core.env.Environment;

import java.util.List;

@Getter
public class FileStorageUnit {

    private final static String BASE_PROP_PATH = "filesys4js.storage.unit";

    private final String fileStorageUnitId;
    private final String mountPoint;
    private final String basePath;

    public FileStorageUnit(Environment env, String fileStorageUnitId) {
        this.fileStorageUnitId = fileStorageUnitId;
        this.mountPoint = env.getProperty(String.format("%s.%s.%s", BASE_PROP_PATH, fileStorageUnitId, "mount-point"));
        this.basePath = env.getProperty(String.format("%s.%s.%s", BASE_PROP_PATH, fileStorageUnitId, "base-path"));
    }

    public List<FS4JSFile> listFiles(String path) {
        return List.of();
    }

    public byte[] getFileContent(String path) {
        return null;
    }

}
