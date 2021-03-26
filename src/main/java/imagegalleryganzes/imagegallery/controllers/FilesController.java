package imagegalleryganzes.imagegallery.controllers;

import imagegalleryganzes.imagegallery.entities.FileInfo;
import imagegalleryganzes.imagegallery.entities.ResponseMessage;
import imagegalleryganzes.imagegallery.repositories.FilesStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("*")
public class FilesController {

    private static final Logger logger = LoggerFactory.getLogger(FilesController.class);
    private static final String SUCCESS = "Uploaded the file successfully: ";
    private static final String FAILED = "Could not upload the file: ";

    @Autowired
    FilesStorageService storageService;

    @PostMapping("/uploadFileToDb")
    public ResponseEntity<ResponseMessage> uploadFileToDisk(@RequestParam("file") MultipartFile file) {

        try {
            storageService.save(file);

            logger.info(SUCCESS + file.getOriginalFilename());

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(SUCCESS));
        } catch (Exception e) {
            logger.warn(FAILED + file.getOriginalFilename());

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(SUCCESS));
        }
    }

    @GetMapping("/filesfromdb")
    public ResponseEntity<List<FileInfo>> getListFilesFromDisk() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
