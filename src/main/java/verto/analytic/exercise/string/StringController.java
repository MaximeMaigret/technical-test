package verto.analytic.exercise.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/verto-analytic")
public class StringController {

    @Autowired
    private StringService service;

    @PostMapping("/upload")
    public void uploadString(@RequestBody List<String> newStrings){
        service.upload(newStrings);
    }

    @PostMapping("/search")
    public List<Set<String>> searchString(@RequestBody String searchString){
        return service.search(searchString);
    }

}
