/* Description: Develop a simplified e-commerce platform:
Create an abstract class Product with fields like productId, name, and price, and an abstract method calculateDiscount().
Extend it into concrete classes: Electronics, Clothing, and Groceries.
Implement an interface Taxable with methods calculateTax() and getTaxDetails() for applicable product categories.
Use encapsulation to protect product details, allowing updates only through setter methods.
Showcase polymorphism by creating a method that calculates and prints the final price (price + tax - discount) for a list of Product.
 */
abstract class Product{
    private int productid;
    private String name;
    private int price;
    Product(int productid,String name,int price)
    {
        this.productid = productid;
        this.name = name;
        this.price = price;
    }
    public abstract double calculateDiscount();
    public int getproductid()
    {
     return productid;
    }
    public void setproductid(int prodcutid)
    {
      this.productid = prodcutid;
    }
    public String getname()
    {
     return name;
    }
    public void setname(String name)
    {
      this.name = name;
    }
    public int getprice()
    {
     return price;
    }
    public void setprice(int price)
    {
      this.price = price;
   }
   void display()
   {
    System.out.println("product id:  "+productid);
     System.out.println("product name:  "+name);
      System.out.println("product price:  "+price);
   }
}
interface Taxable{
    public double calculateTax();
    public String getTaxDetails();
}
class Electronics extends Product implements Taxable
{
    Electronics(int productid,String name,int price)
    {
     super(productid,name,price);
    }
    public double calculateDiscount()
    {
       return getprice()*0.10;
    }
    public double calculateTax() 
    {
       return getprice()*0.15;
    }
    public String getTaxDetails()
    {
        return "Electronic tax: " +calculateTax();
    }
    void finalPrice()
    {
    super.display();
    double discount = calculateDiscount();
    double tax = calculateTax();
    double finalPrice = getprice() + tax - discount;

    System.out.println("Discount applied: " + discount);
    System.out.println("Tax applied: " + tax);
    System.out.println("Final price of Electronics: " + finalPrice);
    }
}
class Clothing extends Product implements Taxable
{
   Clothing(int productid,String name,int price)
    {
     super(productid,name,price);
    }
    public double calculateDiscount()
    {
       return getprice()*0.10;
    }
    public double calculateTax() 
    {
       return getprice()*0.15;
    }
    public String getTaxDetails()
    {
        return "Clothing tax: " +calculateTax();
    }
    void finalPrice()
    {
    super.display();
    double discount = calculateDiscount();
    double tax = calculateTax();
    double finalPrice = getprice() + tax - discount;

    System.out.println("Discount applied: " + discount);
    System.out.println("Tax applied: " + tax);
    System.out.println("Final price of Electronics: " + finalPrice);
    }
}
class Groceries extends Product implements Taxable
{
     Groceries(int productid,String name,int price)
    {
     super(productid,name,price);
    }
    public double calculateDiscount()
    {
       return getprice()*0.10;
    }
    public double calculateTax() 
    {
       return getprice()*0.15;
    }
    public String getTaxDetails()
    {
        return "Groceries tax: " +calculateTax();
    }
    void finalPrice()
    {
    super.display();
    double discount = calculateDiscount();
    double tax = calculateTax();
    double finalPrice = getprice() + tax - discount;

    System.out.println("Discount applied: " + discount);
    System.out.println("Tax applied: " + tax);
    System.out.println("Final price of Electronics: " + finalPrice);
  }
}
public class EcommercePlatform {
    public static void main(String args[])
    {

      Electronics obj = new Electronics(1,"laptop", 50000);
      Clothing obj2 = new Clothing(2,"shirt", 2000);
      Groceries obj3 = new Groceries(3, "rice bag", 4000);
      obj.finalPrice();
       obj2.finalPrice();
       obj3.finalPrice();
    }
}
