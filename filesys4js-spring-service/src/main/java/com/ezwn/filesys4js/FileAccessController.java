package com.ezwn.filesys4js;

import com.ezwn.filesys4js.model.FS4JSFile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("filesys4js/api/v1")
public class FileAccessController {

    private final FileAccessService fileAccessService;

    @GetMapping("/{fileStorageUnit}/{path:.+}")
    public ResponseEntity<List<FS4JSFile>> listFiles(@PathVariable String fileStorageUnit, @PathVariable String path) {
        return ResponseEntity.ok(fileAccessService.listFiles(fileStorageUnit, path));
    }

}
