package DTO;

/**
 *
 * @author macbookpro
 */
public class BillDetail_DTO {
    private int iD;
    private String foodName;
    private int quantity;
    private int price;
    private int totalMoney;

    /**
     * Constructs a BillDetail_DTO with id.
     *
     * @param iD    bill detail's ID
     * @param foodName     bill detail's food name
     * @param quantity     bill detail's quantity
     * @param price     bill's price
     * @param totalMoney
     */
    public BillDetail_DTO(int iD, String foodName, int quantity, int price, int totalMoney) {
        this.iD = iD;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.totalMoney = totalMoney;
    }

    /**
     * Gets the bill detail 's id.
     *
     * @return An int representing the bill detail 's id.
     */
    public int getiD() {
        return iD;
    }

    /**
     * Sets the bill detail 's id.
     *
     * @param iD An int containing the bill detail 's id.
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * Gets the bill detail 's food name.
     *
     * @return An String representing the bill detail 's food name.
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the bill detail 's food name.
     *
     * @param foodName An String containing the bill detail 's food name.
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Gets the bill detail's quantity.
     *
     * @return An int representing the bill detail 's quantity.
     */
    public int getQuantity() {
        return quantity;
    }

     /**
     * Sets the bill detail's quantity.
     *
     * @param quantity An int containing the bill detail's quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the bill detail 's price.
     *
     * @return An int representing the bill detail's price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the bill detail's price.
     *
     * @param price An int containing the bill detail's price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the bill detail 's total Money.
     *
     * @return An int representing the bill detail's Total Money.
     */
    public int getTotalMoney() {
        return totalMoney;
    }

    /**
     * Sets the bill detail's total Money.
     *
     * @param totalMoney An int containing the bill detail's total Money.
     */
    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
    
}
