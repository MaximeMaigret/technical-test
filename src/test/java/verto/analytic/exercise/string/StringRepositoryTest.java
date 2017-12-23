package verto.analytic.exercise.string;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class StringRepositoryTest {

    @InjectMocks
    private StringRepository repository;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void should_addSet_add_string_to_the_stored(){
        Set<String> entry = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));
        repository.addSet(entry);

        List<Set<String>> stored = repository.getAllStoredSetString();

        assertTrue("The stored strings must be the same as the entry one",stored.contains(entry));
    }

    @Test
    public void should_addSet_add_string_to_the_stored_if_not_empty(){
        Set<String> initialEntry = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));
        repository.addSet(initialEntry);
        Set<String> secondEntry = new HashSet<>(Arrays.asList("111", "222", "333"));
        repository.addSet(secondEntry);

        List<Set<String>> stored = repository.getAllStoredSetString();

        assertTrue("The stored strings must be the same as the entry one",stored.contains(initialEntry));
        assertTrue("The stored strings must be the same as the entry one",stored.contains(secondEntry));
    }

}