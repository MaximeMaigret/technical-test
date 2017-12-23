package verto.analytic.exercise.string;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class StringRepository {

    private Set<String> storedStrings = new HashSet<>();

    public Set<String> getAllStoredSetString() {
        return storedStrings;
    }


    public void addSet(Set<String> toUpload) {
        storedStrings.addAll(toUpload);
    }
}
