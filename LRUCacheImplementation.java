//Constraints
//1. Fixed size - The cache size is bounded.
//2. Faster access - Insert and search operations with O(1) time complexity
//3. Faster eviction - If the cache is full, remove the least recently used entity from the cache

public class LRUCacheImplementation {
	private final int CACHE_SIZE = 1000;
	private final Map<ProductData, ProductData> productCache = new HashMap<>();
	private final LinkedList<ProductData> productList = new LinkedList<>();

	public void putEntryIntoCache(final ProductData product) {
		if(productCache.size() == CACHE_SIZE) {
			ProductData lastEntry = productList.peekLast();
			ProductData candidate = productCache.get(lastEntry);
			productData.remove(candidate) // remove the last entry from the cache
			productList.removeLast(); // remove the product data from the list to add new entries)
		}

		productCache.put(product, product);
		productList.addFirst(product);
	}

	public ProductData getCacheEntry(final Product product) {
		ProductData product  productCache.get(product);
		
		if(product != null) {
			productList.remove(product);
			productList.addFirst(product);
			return product;	
		}
		
		return null;
	}
}



class ProductData {
    private String manufacturer;
    private String sku;
    private double price;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProductData that = (ProductData) o;
        return Double.compare(that.price, price) == 0 && manufacturer.equals(that.manufacturer) && sku.equals(that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, sku, price);
    }
}


