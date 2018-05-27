import javax.swing.*;
/** Patron models a Patron with an identification key. */
public class Patron
{ private PatronKey id_number;
  private String name;
  private String address;
  private BookKey[] loaned;  // holds the catalog numbers of Books borrowed 
  private int books;         // counts the number of Books borrowed
    
  /** Constructor Patron constructs the Patron 
    * @param key - the Patron's id number 
    * @param n - the Patron's name
    * @param a - the Patron's address */
  public Patron(PatronKey key, String n, String a)
  { id_number = key;
    name = n;
    address = a;
    loaned = new BookKey[6];
  }
  
  /** Default Constructor constructs an empty Patron */
  public Patron()
  {}
  
  /** loanBook loans a book
    * @param b - the book to be loaned 
    * @return - true, if the book was loaned successfully; false, otherwise. */
  public boolean loanBook(BookKey key)
  { boolean added = false;
    boolean empty_place = findEmptyPlace();
    if(empty_place)
      {int i = 0;
       while(!added && i < loaned.length)
            { if(loaned[i] == null)
                {loaned[i] = key;
                 books = books + 1;
                 added = true;}
              else{i = i + 1;}  
            }
      }
    return added;
  }    
  
  /** findEmptyPlace checks if there is an empty place to add the book
    * @return - true, if there is an emtpy place; false, otherwise */
  public boolean findEmptyPlace()
  { boolean found_empty_place = false;
    int i = 0;
    while(!found_empty_place && i < loaned.length)
         { if(loaned[i] == null)
             {found_empty_place = true;}
           else{i = i + 1;}  
         }
    if(!found_empty_place)
      {JOptionPane.showMessageDialog(null,
       "Patron has reached the maximum number of loans allowed");}     
    return found_empty_place;      
  }

    
  /** returnBook returns a loaned Book 
    * @param b - the book to be returned 
    * @return - true, if the book was returned successfully; false,otherwise. */
  public boolean returnBook(BookKey key)
  { boolean returned = false;
    boolean found = findBook(key);
    if(found)
      { int i = 0;
        while(!returned && i < loaned.length)
             {if(loaned[i] != null && loaned[i] == key)
                {returned = true;
                 loaned[i] = null;
                 books = books - 1;}
              else{i = i + 1;}  
             }       
      }
    return returned;
  }    
  
  /** findBook checks if the book to be returned is at Patron's disposal
    * @return - true if the Book is borrowed by Patron; false, otherwise */
  public boolean findBook(BookKey k)
  { boolean found = false;
    int i = 0;
    while(!found && i < loaned.length)
         {if(loaned[i] != null && loaned[i].equals(k))
            {found = true;}
          else{i = i + 1;}  
         }
    return found;     
  }

  
  /** booksLoaned shows the catalog_number of books currently loaned by Patron */
  public void booksLoaned()
  {if(books == 0)
     {JOptionPane.showMessageDialog(null,"No Books loaned");}
   else{ String answer = "Books loaned: ";
         for(int i = 0; i != loaned.length; i++)
            {if(loaned[i] != null)
               {answer = answer + loaned[i].getInt() + "  ";}
            }
         JOptionPane.showMessageDialog(null,answer);   
       }  
  }

  /** getKey returns the key that identifies the patron
    * @return the key */
  public PatronKey getKey()
  {return id_number;}
  
  /** getName returns the name of the patron
    * @return the name */
  public String getName()
  {return name;}

 /** getAddress returns the address of the patron
    * @return the address */
  public String getAddress()
  {return address;}
  
  public String toString()
  {return "ID Number: " + id_number.getInt() + "\n" +
          "Name: " + name + "\n" + 
          "Address: " + address + "\n" + 
          "Books Loaned: " + books + "\n\n";
  }
}