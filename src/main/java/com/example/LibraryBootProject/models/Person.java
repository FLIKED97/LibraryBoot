package com.example.LibraryBootProject.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Це поле повинно бути заповнене")
    @Size(min = 20, max = 200, message = "Поле повинно бути мінімум від 20 до 200 символів")
    @Pattern(regexp = "[А-ЯІЇЄҐ][а-яіїєґ']+ [А-ЯІЇЄҐ][а-яіїєґ']+ [А-ЯІЇЄҐ][а-яіїєґ']+$", message = "повинно бути у формати Прізвище Ім'я По батькові")
    @Column(name = "full_name")
    private String fullName;
    @NotEmpty(message = "Це поле повинно бути заповнене")
    @Pattern(regexp = "(0[1-9]|[12]\\d|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}$", message = "поле повинно бути у форматі день.місяць.рік (01.02.2001)")
    @Size(max = 50, message = "Розмір повинен бути не більше 50 символів")
    @Column(name = "date")
    private String date;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;
    public Person() {
    }

    public Person(int id, String fullName, String date) {
        this.id = id;
        this.fullName = fullName;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
