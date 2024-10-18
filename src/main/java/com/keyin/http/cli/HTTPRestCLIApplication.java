package com.keyin.http.cli;


import com.keyin.domian.Author;
import com.keyin.domian.Book;
import com.keyin.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApplication {

    private RESTClient restClient;

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public String generateAuthorReport() {
        List<Author> authors = getRestClient().getAllAuthors();

        StringBuilder report = new StringBuilder();

        for (Author author : authors) {
            report.append(author.getAuthorName());
            report.append(" - ");
            report.append(author.getAuthorId());

            if (authors.indexOf(author) != (authors.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public String generateListOfBooksForSpecificAuthor() {
        List<Book> books = getRestClient().getBooksForAuthor();

        StringBuffer report = new StringBuffer();

        for (Book book : books) {
            report.append(book.getTitle());
            report.append(" - ");
            report.append(book.getPublisher());

            if (books.indexOf(book) != (books.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }





    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        String serverURL = args[0];
        //String serverURL = "http://localhost:8080/getBooksForAuthor?authorName=Jordan";


        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

            if (serverURL.contains("greeting")) {

            } else if (serverURL.contains("getBooksForAuthor")) {

                cliApp.generateListOfBooksForSpecificAuthor();
            } else {
                cliApp.generateAuthorReport();
            }
        }

    }
}
