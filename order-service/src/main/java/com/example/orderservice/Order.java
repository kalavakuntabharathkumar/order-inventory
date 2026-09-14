package com.example.orderservice;
import javax.persistence.*;
@Entity @Table(name="order")
public class Order {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String name;
  private Integer quantity;
  public Long getId() { return id; }
  public String getName() { return name; }
  public void setName(String name) { this.name=name; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity=quantity; }
}
