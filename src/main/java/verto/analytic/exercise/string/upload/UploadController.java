package verto.analytic.exercise.string.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/verto-analytic")
public class UploadController {

    @Autowired
    private UploadService service;

    /**
     * Upload a new set of strings.
     * As it is a set, each string must be contained only one time
     *
     * @param  newStrings  the set of strings to upload
     */
    @PostMapping("/upload")
    public void uploadString(@RequestBody List<String> newStrings){
        service.upload(newStrings);
    }
}
