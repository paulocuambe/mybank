package com.gosenx;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
  TransactionService transactionService = new TransactionService();
  ObjectMapper objectMapper = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getRequestURI().equalsIgnoreCase("/")) {
      response.setContentType("text/html; charset=UTF-8");
      response.getWriter().println("<h1>Hello There</h1>" + "<p>Welcome to the transactions application.</p>");
    } else if (request.getRequestURI().equalsIgnoreCase("/api/transactions")) {
      response.setContentType("text/json; charset=UTF-8");
      String json = objectMapper.writeValueAsString(transactionService.findAll());
      response.getWriter().print(json);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getRequestURI().equalsIgnoreCase("/api/transactions")) {
      double amount = Double.parseDouble(request.getParameter("amount"));
      String reference = request.getParameter("reference");

      Transaction transaction = transactionService.create(amount, reference);
      response.setContentType("text/json; charset=UTF-8");
      response.getWriter().print(objectMapper.writeValueAsString(transaction));
    }
  }
}