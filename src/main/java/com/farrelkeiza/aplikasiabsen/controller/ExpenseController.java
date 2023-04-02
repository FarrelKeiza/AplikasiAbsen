package com.farrelkeiza.aplikasiabsen.controller;

import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

import com.farrelkeiza.aplikasiabsen.model.Expense;
import com.farrelkeiza.aplikasiabsen.service.ExpenseService;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addExpense(@ModelAttribute Expense expense) {
        
        expenseService.addExpense(expense);
        //return ResponseEntity.status(HttpStatus.CREATED).build();
        return "redirect:/api/expense";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateExpense(@ModelAttribute Expense expense) {
        expenseService.updateExpense(expense);
        //return ResponseEntity.ok().build();
        return "redirect:/api/expense";
    }

    @GetMapping
    public String getAllExpense(Model model) {
        List<Expense> DataMahasiswa = expenseService.getAllExpense();
        model.addAttribute("Data", DataMahasiswa);
        model.addAttribute("DataEdit", false);
        // return ResponseEntity.ok(expenseService.getAllExpense());
        return "index";
    }

    @GetMapping("/edit/{name}")
    public String updateExpense(Model model,@PathVariable String name) {
        model.addAttribute("DataEdit", true);
        // Mengambil data expense seluruhnya
        List<Expense> DataMahasiswa = expenseService.getAllExpense();
        model.addAttribute("Data", DataMahasiswa);

        // Mengambil data expense 1 untuk di edit
        Expense DataUpdate = expenseService.getExpenseByName(name);
        model.addAttribute("DataUpdate", DataUpdate);
        
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return "redirect:/api/expense";
    }

}
