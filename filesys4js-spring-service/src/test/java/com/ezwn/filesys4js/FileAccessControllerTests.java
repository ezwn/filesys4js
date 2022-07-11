package com.ezwn.filesys4js;

import com.ezwn.filesys4js.model.FS4JSFile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FileAccessController.class)
public class FileAccessControllerTests {

    @MockBean
    FileAccessService fileAccessService;

    private final static String BASE_URL = "/filesys4js/api/v1";
    private final static String FILE_STORAGE_UNIT = "FILE_STORAGE_UNIT";
    private final static String PATH = "PATH";

    @Autowired
    MockMvc mvc;

    @Test
    void givenAStorageUnitAndAPath_whenListFiles_thenReturnFS4JSFileList() throws Exception {

        Mockito.when(fileAccessService.listFiles(FILE_STORAGE_UNIT, PATH)).thenReturn(List.of(
                new FS4JSFile("file1.json"),
                new FS4JSFile("file2.txt")
        ));

        mvc.perform(MockMvcRequestBuilders.get(String.format("%s/%s/%s", BASE_URL, FILE_STORAGE_UNIT, PATH)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("file1.json"));

        Mockito.verify(fileAccessService, Mockito.times(1))
                .listFiles(FILE_STORAGE_UNIT, PATH);
    }

}
