/* Develop a library management system:
Use an abstract class LibraryItem with fields like itemId, title, and author.
Add an abstract method getLoanDuration() and a concrete method getItemDetails().
Create subclasses Book, Magazine, and DVD, overriding getLoanDuration() with specific logic.
Implement an interface Reservable with methods reserveItem() and checkAvailability().
Apply encapsulation to secure details like the borrower’s personal data.
Use polymorphism to allow a general LibraryItem reference to manage all items, regardless of type.
 */
abstract class LibraryItem{
    private int itemid;
    private String title;
    private String author;
    LibraryItem(int itemid,String title,String author)
    {
        this.itemid = itemid;
        this.title = title;
        this.author = author;
    }
    public int getitemid()
    {
        return itemid;
    }
    public void setitemid(int itemid)
    {
      this.itemid = itemid;
    }
    public String gettitle()
    {
        return title;
    }
    public void settitle(String title)
    {
      this.title = title;
    }
    public String getauthor()
    {
        return author;
    }
    public void setauthor(String author)
    {
      this.author = author;
    }
    void getItemDetails()
    {
     System.out.println(" item id:  "+itemid);
     System.out.println("item tiitle:  "+title);
     System.out.println("author:  "+author);
    }
    public abstract int getLoanDuration();
}
interface Reservable 
{
   public void reserveItem(String user);
   public boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable
{
    private boolean isAvailable = true;  
    private String reservedBy;
  Book(int itemid,String title,String author)  
  {
    super(itemid, title, author);
  }
  public int getLoanDuration()
  {
    return 5;
  }
  public boolean checkAvailability()
  {
    return isAvailable;
  }
  public void reserveItem(String user)
  {
    if(isAvailable)
    {
        isAvailable = false;
        reservedBy = user;
        System.out.println("item is reserved by:  "+user);
    }
    else 
    {
        System.out.println("item is not available");
    }
  }
  void getItemDetails()
  {
    super.getItemDetails();
    System.out.println("issue items for days:  "+getLoanDuration());
    System.out.println("is item available:  "+checkAvailability());

  }
}
class Magazine extends LibraryItem implements Reservable{
    private boolean isAvailable = true;  
    private String reservedBy;
    Magazine(int itemid,String title,String author)
    {
        super(itemid, title, author);
    }
   public int getLoanDuration()
  {
    return 7;
  }
  public boolean checkAvailability()
  {
    return isAvailable;
  }
  public void reserveItem(String user)
  {
    if(isAvailable)
    {
        isAvailable = false;
        reservedBy = user;
        System.out.println("item is reserved by:  "+user);
    }
    else 
    {
        System.out.println("item is not available");
    }
  }
  void getItemDetails()
  {
    super.getItemDetails();
    System.out.println("issue items for days:  "+getLoanDuration());
    System.out.println("is item available:  "+checkAvailability());

  }
}
class Dvd extends LibraryItem implements Reservable
{
    private boolean isAvailable = true;  
    private String reservedBy;
   Dvd(int itemid,String title,String author)  
  {
    super(itemid, title, author);
  }
   public int getLoanDuration()
  {
    return 5;
  }
  public boolean checkAvailability()
  {
    return isAvailable;
  }
   public void reserveItem(String user)
  {
    if(isAvailable)
    {
        isAvailable = false;
        reservedBy = user;
        System.out.println("item is reserved by:  "+user);
    }
    else 
    {
        System.out.println("item is not available");
    }
  }
  void getItemDetails()
  {
    super.getItemDetails();
    System.out.println("issue items for days:  "+getLoanDuration());
    System.out.println("is item available:  "+checkAvailability());

  }
}

public class Librarymanagement {
    public static void main(String args[])
    {
      Book obj1 = new Book(1,"wings of fire","abj abdul kalam");
      Magazine obj2 = new Magazine(2,"2 states of my marriage","chetan bhagat");
      Dvd obj3 = new Dvd(3,"half girlfriend","chetan bhagat");
      obj1.getItemDetails();
      obj1.reserveItem("Diksha");
      obj2.getItemDetails();
      obj2.reserveItem("Diksha");
      obj3.getItemDetails();
      obj3.reserveItem("Diksha");

    }
}
