package ginz.restapis.reviews.dao;

import java.util.List;

import ginz.restapis.reviews.model.ProductReview;

public interface IProductReviewDao {

	public List<ProductReview> list();

	public ProductReview create(ProductReview product);

	public ProductReview read(int id);

	public ProductReview update(ProductReview product);

	public void delete(int id);
}
