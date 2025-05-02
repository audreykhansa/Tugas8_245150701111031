package TugasPraktikum8;

import java.text.NumberFormat;

public class Invoice implements Payable {
    private final String productName;
    private final int quantity;
    private final int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    public String getInvoiceDetail() {
        return productName + " x" + quantity + " @ " + pricePerItem + " = " + getPayableAmount();
    }

    public String getInvoiceDetailFormatted(NumberFormat nf) {
        String formatDetail = "%-30s";
        String formatPrice = "%-15s";
    
        return String.format(formatDetail + " = Rp" + formatPrice, productName + " x" + quantity + " @ Rp" + nf.format(pricePerItem), nf.format(getPayableAmount()));
    }        
}
