package com.ezwn.filesys4js;

import com.ezwn.filesys4js.model.FS4JSFile;
import com.ezwn.filesys4js.storage.unit.FileStorageUnit;
import com.ezwn.filesys4js.storage.unit.FileStorageUnitProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(MockitoExtension.class)
public class FileAccessServiceTests {

    private @Mock FileStorageUnit fileStorageUnit;

    private FileAccessService fileAccessService;

    private final static String FILE_STORAGE_UNIT = "FILE_STORAGE_UNIT";
    private final static String PATH = "PATH";

    @BeforeEach
    public void setup(@Mock FileStorageUnitProvider fileStorageUnitProvider) {
        Mockito.when(fileStorageUnitProvider.fileStorageUnit(FILE_STORAGE_UNIT))
                .thenReturn(fileStorageUnit);

        fileAccessService = new FileAccessService(fileStorageUnitProvider);
    }

    @Test
    void givenAStorageUnitAndAPath_whenListFiles_thenReturnFS4JSFileList() {
        final List<FS4JSFile> fileList = List.of(
                new FS4JSFile("index.php")
        );

        Mockito.when(fileStorageUnit.listFiles(PATH)).thenReturn(fileList);

        var files = fileAccessService.listFiles(FILE_STORAGE_UNIT, PATH);
        Assertions.assertEquals(fileList, files);
    }

    @Test
    void givenAStorageUnitAndAPath_whenGetFileContent_thenReturnByteArrayContent() {
        final byte[] bytes = "123456789ABC".getBytes();

        Mockito.when(fileStorageUnit.getFileContent(PATH)).thenReturn(bytes);

        var returnedBytes = fileAccessService.getFileContent(FILE_STORAGE_UNIT, PATH);
        Assertions.assertEquals(returnedBytes, bytes);
    }

}
