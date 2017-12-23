package verto.analytic.exercise.string;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StringControllerUploadIT {

    @Autowired
    private MockMvc mvc;

    /*
        Integration tests
     */
    @Test
    public void should_return_OK_if_different_strings() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        List<String> mySet= Arrays.asList("aaa", "bbb", "ccc");
        String content = mapper.writeValueAsString(mySet);
        mvc.perform(post("/verto-analytic/upload").content(content).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_error_if_duplicate_strings() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        List<String> mySet= Arrays.asList("aaa", "bbb", "aaa");
        String content = mapper.writeValueAsString(mySet);
        mvc.perform(post("/verto-analytic/upload").content(content).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}