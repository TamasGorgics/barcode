package com.tgorgics.barcode;

import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import net.sourceforge.barbecue.BarcodeServlet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BarcodeApplicationTests {

    private BarcodeServlet servlet;
    private MockHttpServletRequest req;
    private MockHttpServletResponse resp;

    @Before
    public void setUp() {
        this.servlet = new BarcodeServlet();
        this.req = new MockHttpServletRequest();
        this.resp = new MockHttpServletResponse();
        this.req.addParameter("data", "Hello, World!");
    }

    @Test
    public void testNotNull() throws ServletException {
        this.servlet.doPost(this.req, this.resp);

        Assert.assertNotNull(this.resp);
    }

    @Test
    public void testIsOk() throws ServletException {
        this.servlet.doPost(this.req, this.resp);

        Assert.assertEquals(this.resp.getStatus(), 200);
    }

    @Test
    public void testIsPng() throws ServletException {
        this.servlet.doPost(this.req, this.resp);

        Assert.assertEquals("image/png", this.resp.getContentType());
    }
}
