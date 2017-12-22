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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StringControllerTest {

    @Autowired
    private MockMvc mvc;

    /*
        Integration test to prove that the endpoint is working fine
     */
    @Test
    public void should_upload_enpoint_return_OK() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Set<String> mySet= new HashSet<>(Arrays.asList("aaa", "bbb", "ccc"));
        String content = mapper.writeValueAsString(mySet);
        mvc.perform(MockMvcRequestBuilders.post("/verto-analytic/upload").content(content).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}