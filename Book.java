import javax.swing.*;

/** Book models a Book with an identification key. */
public class Book
{ private BookKey catalog_number;                
  private String title;            
  private String author;          
  private String genre;            
  private int publication_year;         
  private boolean is_borrowed;  // tells if the book is borrowed by someone   
  private int number_of_borrows;    // tells how many times the book has been borrowed
  private int id_of_borrower;                
  private String date_to_return;   // date to return book(dd/mm/yyyy)     
  
  
  /** Constructor Book constructs the book.
    * @param k - the book's catalog number
    * @param t - the book's title
    * @param a - the book's author 
    * @param g - the book's genre
    * @param y - the book's publication year */
  public Book( BookKey k, String t, String a, String g, int y )
  { catalog_number = k;
    title = t;
    author = a;
    genre = g;
    publication_year = y;
  }
  
  /** Default Constructor constructs an empty book */
  public Book()
  {}
  
  /** loanTo loans a Book to somebody
    * @param key - the id of the borrower
    * @param d - the date to return the book */
  public boolean loanTo(PatronKey key, String d)
  { boolean loaned = false;
    if(is_borrowed == false)
      { is_borrowed = true;
        id_of_borrower = key.getInt();
        number_of_borrows = number_of_borrows + 1;
        date_to_return = d;
        loaned = true;
      }
    else{JOptionPane.showMessageDialog(null,
        "Book: " + catalog_number.getInt() + " is already borrowed by someone");}  
    return loaned;
  }
  
  /** returnFrom returns a loaned Book
    * @param key - the id of borrower
    * @return true - if the book was successfuly returned; false, otherwise */ 
  public boolean returnFrom(PatronKey key)
  { boolean returned = false;
    if(is_borrowed == true && key.getInt() == id_of_borrower)
      { is_borrowed = false;
        id_of_borrower = 0;
        date_to_return = "";
        returned = true;
      }
    else{JOptionPane.showMessageDialog(null,"Book is not loaned to anyone");}  
    return returned;  
  }
  
  /** getKey returns the key that identifies the book
    * @return the key */
  public BookKey getKey() {return catalog_number;} 
  
  /** getTitle returns the title of the book
    * @return the title */
  public String getTitle() {return title;} 
  
  /** getAuthor returns the author of the book
    * @return the author */
  public String getAuthor() {return author;}
  
  /** getGenre returns the genre of the book
    * @return the genre */
  public String getGenre() {return genre;}
  
  /** getPublicationYear returns the publication year of the book
    * @return the publication_year */
  public int getPublicationYear() {return publication_year;}
  
  /** getBorrowed tells if the book is borrowed by someone
    * @return true - if the book is borrowed, false otherwise */
  public boolean getBorrowed() {return is_borrowed;}
  
  /** getNumberOfBorrows returns the number of how many time the book has been borrowed 
    * @return the number_of_borrows */
  public int getNumberOfBorrows() {return number_of_borrows;}
  
  /** getIdOfBorrower returns the id number of book's borrower 
    * @return the id_of_borrower */
  public int getIdOfBorrower() {return id_of_borrower;}
  
  /** getDateToReturn returns the date for the book to be returned 
    * @return the date_to_return */
  public String getDateToReturn() {return date_to_return;}
  
  /** toString shows the string representation of the object 
    * @return - the string format */ 
  public String toString()
  { return "Catalog Number: " + catalog_number.getInt() + "\n" +
           "Title: " + title + "\n" + 
           "Author: " + author + "\n" + 
           "Genre: " + genre + "\n" + 
           "Publication Year: " + publication_year + "\n" + 
           "Borrowed: " + is_borrowed + "\n" + 
           "Number of borrows: " + number_of_borrows + "\n" +
           "Borrower Id: " + id_of_borrower + "\n" +
           "Date to return: " + date_to_return + "\n\n";
  }
}