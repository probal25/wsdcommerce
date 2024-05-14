package ws.probal.wsdcommerce;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WishListResourceTest {

    @Autowired
    private MockMvc mockMvc;

    private final String BASE_WISH_LIST_URL = "/api/v1/wsd/wish-list";

    @Test
    public void testExpectFound() throws Exception {
        mockMvc.perform(get(BASE_WISH_LIST_URL + "/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testExpectNotFound() throws Exception {
        mockMvc.perform(get(BASE_WISH_LIST_URL + "/100"))
                .andExpect(status().isNotFound());
    }
}
