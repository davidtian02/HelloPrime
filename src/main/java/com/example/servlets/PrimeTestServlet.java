package com.example.servlets;

import com.example.utils.MathUtils;
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
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("Bad input: " + number);
            response.getWriter().write(GSON.toJson(new Result(false, "Invalid input, please set parameter to be valid integer.")));
            return;
        }

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.getWriter().write(GSON.toJson(new Result(MathUtils.isPrime(num), null)));
    }

    class Result {
        @SerializedName("result")
        boolean mResult;

        @SerializedName("error_message")
        String mErrorMessage;

        Result(boolean result, String errorMessage) {
            mResult = result;
            mErrorMessage = errorMessage;
        }
    }
}
