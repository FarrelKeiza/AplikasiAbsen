package com.farrelkeiza.aplikasiabsen.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("expense")
public class Expense {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;
    @Field(name = "category")
    private String expenseCategory;
    @Field(name = "amount")
    private BigDecimal expenseMount;

    public Expense(String id, String expenseName, String expenseCategory, BigDecimal expenseMount) {
        this.id = id;
        this.expenseName = expenseName;
        this.expenseCategory = expenseCategory;
        this.expenseMount = expenseMount;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public void setExpenseMount(BigDecimal expenseMount) {
        this.expenseMount = expenseMount;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public BigDecimal getExpenseMount() {
        return expenseMount;
    }

}
