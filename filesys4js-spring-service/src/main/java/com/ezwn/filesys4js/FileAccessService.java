package com.ezwn.filesys4js;

import com.ezwn.filesys4js.model.FS4JSFile;
import com.ezwn.filesys4js.storage.unit.FileStorageUnitProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileAccessService {

    private final FileStorageUnitProvider fileStorageUnitProvider;

    public List<FS4JSFile> listFiles(String fileStorageUnitId, String path) {
        return fileStorageUnitProvider.fileStorageUnit(fileStorageUnitId).listFiles(path);
    }

    public byte[] getFileContent(String fileStorageUnitId, String path) {
        return fileStorageUnitProvider.fileStorageUnit(fileStorageUnitId).getFileContent(path);
    }

}
