package fixplayground;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FixControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() {}

    @Test
    public void pingWorks() throws Exception {
        this.mockMvc.perform(get("/0/ping")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(is("ping")));
    }

    @Test
    public void fieldNameMissingIsBadRequest() throws Exception {
        this.mockMvc.perform(get("/0/fieldname")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void nonexistentFieldNameReturnsEmpty() throws Exception {
        this.mockMvc.perform(get("/0/fieldname").param("code", "1234567"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(is("")));
    }

    @Test
    public void goodFieldNameWorks() throws Exception {
        this.mockMvc.perform(get("/0/fieldname").param("code", "135"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(is("OfferSize")));
    }
}
