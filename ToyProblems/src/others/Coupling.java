package others;
/*
public class Coupling {

	public static void main(String[] args){
		//Coupling cp=new Coupling();
		ShoppingCartEntry item1=new ShoppingCartEntry();
		ShoppingCartEntry item2=new ShoppingCartEntry();
		item1.price =(float) 6.60;
		item2.price =(float) 8.40;
		item1.quantity=10;
		item2.quantity=5;
		ShoppingCartEntry[] items = {item1,item2};
		ShoppingCart cart=new ShoppingCart(items);
		float salesTax=(float)0.05;
		Order o1=new Order(cart,salesTax);
		float total=o1.orderTotalPrice();
		System.out.println(total);
	}
}
	//Coupling is a measure of how much a class is dependent on other classes. 
	//There should minimal dependencies between classes.
	//Consider the example below:

	class ShoppingCartEntry {
		public float price;
		public int quantity;
	}

	class ShoppingCart {
		public ShoppingCartEntry[] items;
		
		public ShoppingCart(ShoppingCartEntry[] stuff){
			this.items = stuff;
		}
	}

	class Order {
		private ShoppingCart cart;
		private float salesTax;

		public Order(ShoppingCart cart, float salesTax) {
			this.cart = cart;
			this.salesTax = salesTax;
		}

		// This method know the internal details of ShoppingCartEntry and
		// ShoppingCart classes. If there is any change in any of those
		// classes, this method also needs to change.
		public float orderTotalPrice() {
			float cartTotalPrice = 0;
			for (int i = 0; i < cart.items.length; i++) {
				cartTotalPrice += cart.items[i].price * cart.items[i].quantity;
			}
			cartTotalPrice += cartTotalPrice * salesTax;
			return cartTotalPrice;
		}
	}
	
	
/************************************/
	
	   class ShoppingCartEntry {
		private float price;
		private int quantity;
		
		public ShoppingCartEntry(float price,int quantity){
			this.price=price;
			this.quantity=quantity;
		}
		
		public float getTotalPrice(){
			return price*quantity;
		}
	}

	class ShoppingCart {
		private ShoppingCartEntry[] items;
		
		public ShoppingCart(ShoppingCartEntry[] stuff){
			this.items = stuff;
		}
		
		public ShoppingCartEntry[] getItems(){
			return this.items;
		}
	}

	class Order {
		private ShoppingCart cart;
		private float salesTax;

		public Order(ShoppingCart cart, float salesTax) {
			this.cart = cart;
			this.salesTax = salesTax;
		}

		// This method know the internal details of ShoppingCartEntry and
		// ShoppingCart classes. If there is any change in any of those
		// classes, this method also needs to change.
		public float orderTotalPrice() {
			float cartTotalPrice = 0;
			ShoppingCartEntry[] items = cart.getItems();
			for (int i = 0; i < items.length; i++) {
				cartTotalPrice += items[i].getTotalPrice();
			}
			cartTotalPrice += cartTotalPrice * salesTax;
			return cartTotalPrice;
		}
	}
	
public class Coupling {
	public static void main(String[] args){
		//Coupling cp=new Coupling();
		ShoppingCartEntry item1=new ShoppingCartEntry(6.60f,10);
		ShoppingCartEntry item2=new ShoppingCartEntry(8.40f,5);

		ShoppingCartEntry[] items = {item1,item2};
		ShoppingCart cart=new ShoppingCart(items);
		float salesTax=(float)0.05;
		Order o1=new Order(cart,salesTax);
		float total=o1.orderTotalPrice();
		System.out.println(total);
	}
}


