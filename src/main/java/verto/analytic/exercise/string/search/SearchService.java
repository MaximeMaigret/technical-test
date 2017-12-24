package verto.analytic.exercise.string.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import verto.analytic.exercise.string.StringRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    StringRepository repository;

    public List<Set<String>> search(String searchString) {
        return repository.getAllStoredSetString().stream().filter(s -> s.contains(searchString)).collect(Collectors.toList());
    }
}
