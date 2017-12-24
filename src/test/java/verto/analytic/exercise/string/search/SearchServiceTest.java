package verto.analytic.exercise.string.search;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import verto.analytic.exercise.string.StringRepository;
import verto.analytic.exercise.string.upload.UploadService;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SearchServiceTest {

    @InjectMocks
    private SearchService service;

    @Mock
    private StringRepository repository;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_look_into_all_stored_strings(){
        String searchedString = "bbb";
        Set<String> setContainingSearchedString = new HashSet<>(Arrays.asList("aaa", searchedString, "ccc"));
        Set<String> setNotContainingSearchedString = new HashSet<>(Arrays.asList("111", "222", "333"));
        List<Set<String>> allStoredSet = Arrays.asList(setContainingSearchedString,setNotContainingSearchedString);

        when(repository.getAllStoredSetString()).thenReturn(allStoredSet);

        List<Set<String>> result = service.search(searchedString);

        assertEquals("Must return only set containing the searched string.", Collections.singletonList(setContainingSearchedString), result);
    }
}
