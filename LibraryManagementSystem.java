package com.java;

import java.sql.*;
import java.util.Scanner;

public class LibraryManagementSystem {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/LibraryDB";
    static final String JDBC_USER = "root";
    static final String JDBC_PASSWORD = "Nikita@29"; // Change to your MySQL password
    Connection connection;
    Scanner scanner;

    public LibraryManagementSystem() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        scanner = new Scanner(System.in);
    }

    public void manageMembers() {
        System.out.println("Member Management System");
        System.out.println("1. Add Member");
        System.out.println("2. Update Member");
        System.out.println("3. View All Members");
        System.out.println("4. Delete Members");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addMember();
                break;
            case 2:
                updateMember();
                break;
            case 3:
                viewAllMembers();
                break;
            case 4:
            	deleteMember();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageMembers();
        }
    }
    public void manageAuthor() {
        System.out.println("Member Management System");
        System.out.println("1. Add Author");
        System.out.println("2. Update Author");
        System.out.println("3. View All Author");
        System.out.println("3. Delete Author");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addAuthor();
                break;
            case 2:
                updateAuthor();
                break;
            case 3:
                viewAllAuthor();
                break;
            case 4:
                deleteAuthor();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageMembers();
        }
    }
    public void manageBooks() {
        System.out.println("Member Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book");
        System.out.println("3. View All Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                updateBook();
                break;
            case 3:
                viewAllBooks();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageMembers();
        }
    }
    public void addBook() {
        System.out.println("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter Book Author: ");
        String author = scanner.nextLine();
        String query = "INSERT INTO books (id, title, author, isAvailable) VALUES (?, ?, ?, true)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateBook() {
        System.out.println("Enter Book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new Book Title: ");
        String title = scanner.nextLine();
        System.out.println("Enter new Book Author: ");
        String author = scanner.nextLine();
        String query = "UPDATE books SET title =?, author =? WHERE id =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMember() {
        System.out.println("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Member Name: ");
        String name = scanner.nextLine();
        String query = "INSERT INTO members (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
            System.out.println("Member added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMember() {
        System.out.println("Enter Member ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new Member Name: ");
        String name = scanner.nextLine();
        String query = "UPDATE members SET name =? WHERE id =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Member updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addAuthor() {
        System.out.println("Enter Author ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Author Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter bith Date : ");
        String bith = scanner.nextLine();
        String query = "INSERT INTO author (id, name,bithdate) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, bith);
            stmt.executeUpdate();
            System.out.println("Author added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAuthor() {
        System.out.println("Enter Author ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new Author Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new Birth Date: ");
        String bith = scanner.nextLine();
        String query = "UPDATE author SET name =?, bithdate=? WHERE id =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, bith);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Author updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteMember() {
        System.out.print("Enter the Member ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String query = "DELETE FROM members WHERE id =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Member deleted successfully.");
            } else {
                System.out.println("Member not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAuthor() {
        System.out.print("Enter the Author ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String query = "DELETE FROM author WHERE id =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Author deleted successfully.");
            } else {
                System.out.println("Author not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook() {
        System.out.print("Enter the Book ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String query = "DELETE FROM books WHERE id =?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Book was deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void borrowBook() {
        System.out.println("Enter Member ID: ");
        int memberId = scanner.nextInt();
        System.out.println("Enter Book ID: ");
        int bookId = scanner.nextInt();

        String checkBookQuery = "SELECT isAvailable FROM books WHERE id = ?";
        String borrowBookQuery = "UPDATE books SET isAvailable = false WHERE id = ?";
        String logTransactionQuery = "INSERT INTO transactions (memberId, bookId, action) VALUES (?, ?, 'BORROW')";
        
        try (PreparedStatement checkStmt = connection.prepareStatement(checkBookQuery);
             PreparedStatement borrowStmt = connection.prepareStatement(borrowBookQuery);
             PreparedStatement logStmt = connection.prepareStatement(logTransactionQuery)) {
            
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getBoolean("isAvailable")) {
                borrowStmt.setInt(1, bookId);
                borrowStmt.executeUpdate();

                logStmt.setInt(1, memberId);
                logStmt.setInt(2, bookId);
                logStmt.executeUpdate();

                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book is not available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook() {
        System.out.println("Enter Member ID: ");
        int memberId = scanner.nextInt();
        System.out.println("Enter Book ID: ");
        int bookId = scanner.nextInt();

        String checkBookQuery = "SELECT isAvailable FROM books WHERE id = ?";
        String returnBookQuery = "UPDATE books SET isAvailable = true WHERE id = ?";
        String logTransactionQuery = "INSERT INTO transactions (memberId, bookId, action) VALUES (?, ?, 'RETURN')";
        
        try (PreparedStatement checkStmt = connection.prepareStatement(checkBookQuery);
             PreparedStatement returnStmt = connection.prepareStatement(returnBookQuery);
             PreparedStatement logStmt = connection.prepareStatement(logTransactionQuery)) {
            
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && !rs.getBoolean("isAvailable")) {
                returnStmt.setInt(1, bookId);
                returnStmt.executeUpdate();

                logStmt.setInt(1, memberId);
                logStmt.setInt(2, bookId);
                logStmt.executeUpdate();

                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book was not borrowed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        String query = "SELECT * FROM books";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	System.out.println("***************|| Books Table ||*******************");
        	System.out.println();
            while (rs.next()) {
                System.out.println("Book [ID=" + rs.getInt("id") + ", Title=" + rs.getString("title") + 
                                   ", Author=" + rs.getString("author") + ", Available=" + rs.getBoolean("isAvailable") + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllMembers() {
        String query = "SELECT * FROM members";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	System.out.println("***************|| Member Table ||*******************");
        	System.out.println();
            while (rs.next()) {
                System.out.println("Member [ID = " + rs.getInt("id") + " , Name = " + rs.getString("name") + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewAllAuthor() {
        String query = "SELECT * FROM author ";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	System.out.println("***************|| Author Table ||*******************");
        	System.out.println();
            
            while (rs.next()) {
                System.out.println("Author [ID=" + rs.getInt("id") + ",  Name=" + rs.getString("name") + " ,  BirthDate="+ rs.getString("bithdate") +"]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllTransactions() {
        String query = "SELECT * FROM transactions";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	System.out.println("***************|| Transactions Table ||*******************");
        	System.out.println();
            
            while (rs.next()) {
            	
                System.out.println("Transactions [ID=" + rs.getInt("id") + ", memberId=" + rs.getInt("memberId") + " , bookId=" + rs.getInt("bookId") + " , action=" + rs.getString("action") + ", date=" + rs.getTimestamp("date") + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
        	System.out.println();
        	System.out.println("------------------------------------------------------------------------------");
            System.out.println("**********************|| Library Management System ||*************************");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("-------------|| Add Operation here ||---------------");
            System.out.println("");
            System.out.println("1. Manage Book");
            System.out.println("2. Manage Member");
            System.out.println("3. Manage Author");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println(":----Choose above any one option to perform the operation--- : ");
       

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    library.manageBooks();
                    break;
                case 2:
                    library.manageMembers();
                    break;
                case 3:
                    library.manageAuthor();
                    break;
                case 4:
                    library.borrowBook();
                    break;
                case 5:
                    library.returnBook();
                    break;
                case 6:
                    library.viewAllTransactions();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
