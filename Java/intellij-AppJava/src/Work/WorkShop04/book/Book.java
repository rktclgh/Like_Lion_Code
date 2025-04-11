package Work.WorkShop04.book;

public class Book {
    private String bookName;
    private int bookPrice;
    private double DiscountRate;




    public Book() {
    }

    public Book(String bookName, int bookPrice, double DiscountRate) {
        this.setBookName(bookName);
        this.setBookPrice(bookPrice);
        this.setDiscountRate(DiscountRate);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getDiscountRate() {
        return DiscountRate;
    }

    public void setDiscountRate(double discountRate) {
        DiscountRate = discountRate;
    }

    public double getDiscountBookPrice()
    {
        return (1-DiscountRate/100)*(double) bookPrice;
    }
}
