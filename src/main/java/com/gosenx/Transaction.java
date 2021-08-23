package com.gosenx;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction {
  private String id;
  private double amount;
  private String reference;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
  private Date timestamp;

  public Transaction(){
  }

  public Transaction(double amount, String reference){
    this.id = UUID.randomUUID().toString();
    this.amount = amount;
    this.reference = reference;
    this.timestamp = new Date();
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public double getAmount(){
    return amount;
  }

  public void setAmount(double amount){
    this.amount = amount;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

}
