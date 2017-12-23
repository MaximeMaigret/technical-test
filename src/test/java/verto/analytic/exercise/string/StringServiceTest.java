package verto.analytic.exercise.string;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.WebFault;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class StringServiceTest {

    @InjectMocks
    private StringService service;

    @Mock
    private StringRepository repository;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void should_take_any_number_of_string_on_upload() {
        List<String> entry = (Arrays.asList("aaa", "bbb", "ccc"));

        service.upload(entry);

        verify(repository).addSet(new HashSet<>(entry));
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