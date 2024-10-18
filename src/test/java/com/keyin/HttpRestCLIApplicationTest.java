package com.keyin;

import com.keyin.domian.Author;
import com.keyin.domian.Book;
import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HttpRestCLIApplicationTest {

    @Mock
    private RESTClient mockRestClient;

    @InjectMocks
    private HTTPRestCLIApplication httpRestCLIApplicationUnderTest;

    @BeforeEach
    void setUp() {
        httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();
        httpRestCLIApplicationUnderTest.setRestClient(mockRestClient);
    }

    // In Pom.xml I had to upgrade the version of Junit and Mockito to get it to work correctly. If you copied over before I made this change. I apologize! Was trying to fix it

    @Test
    public void testGenerateAuthorList() {
        HTTPRestCLIApplication httpRestCLIApplicationUnderTest = new HTTPRestCLIApplication();


        Author author = new Author();


        author.setAuthorName("Lee Child");
        author.setAuthorId(1L);




        List<Author> authorList = new ArrayList<Author>();

        authorList.add(author);



        Mockito.when(mockRestClient.getAllAuthors()).thenReturn(authorList);
        httpRestCLIApplicationUnderTest.setRestClient(mockRestClient);

        Assertions.assertTrue(httpRestCLIApplicationUnderTest.generateAuthorReport().contains("Lee Child"));
    }
}
