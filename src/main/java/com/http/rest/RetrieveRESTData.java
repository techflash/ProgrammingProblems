package com.http.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RetrieveRESTData {
    static String[] getMovieTitles(String substr) {
        String urlString = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
        List<String> titles = new ArrayList<>();

        try {
            HttpURLConnection conn = getHttpUrlConnection(urlString + substr + "&page=" + 1);
            ResponseData firstResponse = null;

            if (conn.getResponseCode() == 200) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                firstResponse = gson.fromJson(getResponseAsString(conn), ResponseData.class);
                firstResponse.data.forEach(movie -> titles.add(movie.getTitle()));

            }

            conn.disconnect();
            int pageCount = 1;

            while (pageCount < firstResponse.getTotal_pages()) {
                conn = getHttpUrlConnection(urlString + substr + "&page=" + ++pageCount);

                if (conn.getResponseCode() == 200) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    ResponseData subsequentResponse = gson.fromJson(getResponseAsString(conn), ResponseData.class);
                    subsequentResponse.data.stream().forEach(movie -> titles.add(movie.getTitle()));
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String[] moviesTitles = new String[titles.size()];
        titles.toArray(moviesTitles);
        Arrays.sort(moviesTitles);
        return moviesTitles;
    }

    private static HttpURLConnection getHttpUrlConnection(String urlString) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        return conn;
    }

    private static String getResponseAsString(HttpURLConnection conn) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");

//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
//        String _substr;
//        try {
//            _substr = in.nextLine();
//        } catch (Exception e) {
//            _substr = null;
//        }

        res = getMovieTitles("spiderman");
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(res[res_i]);
        }

//        bw.close();
    }


    class ResponseData {
        private int page;
        private int per_page;
        private int total;
        private int total_pages;
        private List<Movie> data;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public List<Movie> getData() {
            return data;
        }

        public void setData(List<Movie> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ResponseData{" +
                    "page=" + page +
                    ", per_page=" + per_page +
                    ", total=" + total +
                    ", total_pages=" + total_pages +
                    ", data=" + data +
                    '}';
        }
    }

    class Movie {
        private String Poster;
        private String Title;
        private String Type;
        private int Year;
        private String imdbID;

        public String getPoster() {
            return Poster;
        }

        public String getTitle() {
            return Title;
        }

        public String getType() {
            return Type;
        }

        public int getYear() {
            return Year;
        }

        public String getImdbID() {
            return imdbID;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "Poster='" + Poster + '\'' +
                    ", Title='" + Title + '\'' +
                    ", Type='" + Type + '\'' +
                    ", Year=" + Year +
                    ", imdbID='" + imdbID + '\'' +
                    '}';
        }
    }

}



