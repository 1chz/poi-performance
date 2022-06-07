package io.github.shirohoo.poi.performance;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class ExcelDownloaderTests {
    MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();

        assertNotNull(this.mockMvc);
    }

    @Test
    void forXSSF() throws Exception {
        mockMvc.perform(get("/excel/xssf"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void forSXSSF() throws Exception {
        mockMvc.perform(get("/excel/sxssf"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}