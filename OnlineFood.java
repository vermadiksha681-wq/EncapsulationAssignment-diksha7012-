/* Description: Create an online food delivery system:
Define an abstract class FoodItem with fields like itemName, price, and quantity.
Add abstract methods calculateTotalPrice() and concrete methods like getItemDetails().
Extend it into classes VegItem and NonVegItem, overriding calculateTotalPrice() to include additional 
charges (e.g., for non-veg items). Use an interface Discountable with methods applyDiscount() and
getDiscountDetails(). Demonstrate encapsulation to restrict modifications to order details and use polymorphism
to handle different types of food items in a single order-processing method.  */
abstract class FoodItem 
{
    String itemName;
    int price;
    int quantity;
    FoodItem(String itemName,int price,int quantity)
    {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getitemName()
    {
        return itemName;
    }
    public void setitemName(String itemName)
    {
        this.itemName = itemName;
    }
    public int getprice()
    {
        return price;
    }
    public void setprice(int price)
    {
        this.price = price;
    }
    public int getquantity()
    {
        return quantity;
    }
    public void setquantity(int quantity)
    {
        this.quantity = quantity;
    }
    void getitemDetails(){
        System.out.println("item name: "+itemName);
        System.out.println("item price:  "+price);
        System.out.println("item quantity:  "+quantity);
    }
    public abstract double calculateTotalPrice(); 
}
interface Discountable
{
    public double applyDiscount();
    public void getDiscountDetails();
}
class  VegItem extends FoodItem implements Discountable{
     VegItem(String itemName,int price,int quantity)
    {
        super(itemName, price, quantity);
    }
     public double calculateTotalPrice()
    {
      return getprice()*quantity;
    }
    public double applyDiscount()
    {
      return calculateTotalPrice()*0.10;
    }
    public void getDiscountDetails()
    {
        System.out.println("discount on item:  "+applyDiscount());
    }

    void getitemDetails()
    {
      super.getitemDetails();
      double total =calculateTotalPrice();
      double discount =applyDiscount();
      double finalPrice = total - discount;
      System.out.println("total price before discount:  "+total);
      getDiscountDetails();
      System.out.println("final price after discount:  "+finalPrice);
      
    }
}
class  NonVegItem extends FoodItem implements Discountable{
     NonVegItem(String itemName,int price,int quantity)
    {
       super(itemName, price, quantity);
    }
     public double calculateTotalPrice()
    {
      return getprice()*quantity;
    }
    public double applyDiscount()
    {
      return calculateTotalPrice()*0.10;
    }
    public void getDiscountDetails()
    {
        System.out.println("discount on item:  "+applyDiscount());
    }
   
    void getitemDetails()
    {
    super.getitemDetails();
      double total =calculateTotalPrice();
      double discount =applyDiscount();
      double finalPrice = total - discount;
      System.out.println("total price before discount:  "+total);
      getDiscountDetails();
      System.out.println("final price after discount:  "+finalPrice);
    }
}

public class OnlineFood {
    public static void main(String args[])
    {
      VegItem obj1 = new VegItem("burger",60,2);
      NonVegItem obj2 = new NonVegItem("salmon",200,3);
      obj1.getitemDetails();
      obj2.getitemDetails();
    }
}
