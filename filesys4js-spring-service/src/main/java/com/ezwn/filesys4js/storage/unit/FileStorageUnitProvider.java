package com.ezwn.filesys4js.storage.unit;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileStorageUnitProvider {

    private final Environment env;

    @Cacheable("fileStorageUnit")
    public FileStorageUnit fileStorageUnit(String fileStorageUnitId) {
        return new FileStorageUnit(env, fileStorageUnitId);
    }

}
