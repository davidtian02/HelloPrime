package com.example.servlets;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.annotations.SerializedName;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrimeTestServlet extends HttpServlet {

    private static final Gson GSON = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String number = request.getParameter("number");
        int num = -1;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            log("Bad input: " + number);
            response.getWriter().write(GSON.toJson(getResponseWithResult()));
            return;
        }

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.getWriter().write(GSON.toJson(getResponseWithResult()));
    }

    protected Result getResponseWithResult() {
        return null;
    }

    class Result {
        @SerializedName("result")
        public boolean result;

        @SerializedName("errorMessage")
        public String errorMessage;
    }
}
