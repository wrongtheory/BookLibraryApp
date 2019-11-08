package vleunti.springbootframework.libraryapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import vleunti.springbootframework.libraryapp.controllers.ReaderController;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReaderController.class)
@ContextConfiguration(classes = LibraryappApplication.class)
public class ReaderControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup () {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void testReaderController() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/readers");
        this.mockMvc.perform(builder).andExpect(ok);


        builder = MockMvcRequestBuilders.get("/addreader");
        this.mockMvc.perform(builder).andExpect(ok);

        builder = MockMvcRequestBuilders.get("/allreaders");
        this.mockMvc.perform(builder).andExpect(ok);

        builder  = MockMvcRequestBuilders.get("/searchreader");
        this.mockMvc.perform(builder).andExpect(ok);

        builder = MockMvcRequestBuilders.get("/searchreader?id=20192&book_id=1");
        this.mockMvc.perform(builder).andExpect(redirectedUrl("/searchreader?id=20192")).andDo(print());
    }

}
