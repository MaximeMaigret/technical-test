package verto.analytic.exercise.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StringService {

    @Autowired
    StringRepository repository;

    public void upload(List<String> toVerify){
        Set<String> duplicates = getDuplicates(toVerify);

        if(!duplicates.isEmpty()){
            throw new DuplicateStringException("Parameter must be a set, so no duplicate strings are allowed for values : "+duplicates);
        }

        repository.addSet(new HashSet<>(toVerify));
    }

    private Set<String> getDuplicates(List<String> toVerify) {
        return toVerify.stream()
                .filter(i -> Collections.frequency(toVerify, i) >1)
                .collect(Collectors.toSet());
    }

    public List<Set<String>> search(String searchString) {
        return repository.getAllStoredSetString().stream().filter(s -> s.contains(searchString)).collect(Collectors.toList());
    }
}
