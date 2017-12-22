package verto.analytic.exercise.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/verto-analytic")
public class StringController {

    @Autowired
    private StringService service;

    @PostMapping("/upload")
    public void uploadString(@RequestBody Set<String> newStrings){
        // TODO
    }
}
