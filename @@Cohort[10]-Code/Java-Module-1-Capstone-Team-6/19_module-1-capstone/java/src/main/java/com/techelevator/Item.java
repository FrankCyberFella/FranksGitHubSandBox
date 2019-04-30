package com.techelevator;

public class Item {
	private String name;
	private String type;
	private String price;
	private int amount;
	private int sales = 0;



	public Item(String name, String price, String type, int amount) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the sales
	 */
	public int getSales() {
		return sales;
	}

	/**
	 * @param sales the sales to set
	 */
	public void addSale() {
		this.sales = sales + 1;
	}

//Methods

public String message() {
	if (this.type.equals("Chip")){
			return "Crunch Crunch, Yum!";
		} else {
			if (this.type.equals("Candy")) {
				return "Munch Munch, Yum!";

			} else {
				if (this.type.equals("Drink")) {
					return "Glug Glug, Yum!";

				} else {
					if (this.type.equals("Gum")) {
						return "Chew Chew, Yum";

					}

				}
			}
		}
		return "";
	}

@Override
public String toString() {
		return this.name + " $" + this.price + " qty. " + this.amount;
	}

public double getPriceToDouble() {
	return Double.parseDouble(this.price);
}

public void reduceAmount() {
	this.amount -= 1;
}


}