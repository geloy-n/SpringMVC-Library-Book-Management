package com.MyLearning.Library.controller;

import com.MyLearning.Library.entity.Book;
import com.MyLearning.Library.service.BookService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/list")
    public String listBook(Model theModel) {
        List<Book> theBooks = bookService.findAll();
        theModel.addAttribute("books", theBooks);
        return "books/list-books";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);
        return "books/book-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
        Book theBook = bookService.findById(theId);
        theModel.addAttribute("book", theBook);
        return "books/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book theBook) {
        bookService.save(theBook);
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {
        bookService.deleteById(theId);
        return "redirect:/books/list";
    }

}
