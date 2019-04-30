package com.techelevator.reviews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.reviews.dao.ProductReviewDao;
import com.techelevator.reviews.exception.ProductReviewNotFoundException;
import com.techelevator.reviews.model.ProductReview;


@RestController // tells Spring MVC this is a REST API controller
@CrossOrigin
@RequestMapping("/api/reviews") // handle this path in URL
public class ProductReviewsController {
	
	private ProductReviewDao productReviewDAO;
	
	public ProductReviewsController(ProductReviewDao productReviewDAO) {
		this.productReviewDAO = productReviewDAO;
	}

	@GetMapping  // handle any GET requests for the URL path in @RequestMapping
	public List<ProductReview> list() {
		return productReviewDAO.list();   // Note, not a string/jsp name, now we are returning data.
	}
	
	@GetMapping("/{id}")  // handle any GET requests with an id for the URL path in @RequestMapping
	public ProductReview read(@PathVariable int id) throws ProductReviewNotFoundException {
		ProductReview productReview = productReviewDAO.read(id); // get the entry with this id
		if( productReview != null ) {
			return productReview;
		} else { // if entry not found, throw custom Exception
			throw new ProductReviewNotFoundException(id,"Product Review Not Found!");
		}
	}
	
	@PostMapping  // handle any POST requests for the URL path in @RequestMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductReview create(@RequestBody ProductReview productReview) {
		return productReviewDAO.create(productReview);
	}
	
	@PutMapping("/{id}")// handle any POST requests with an id for the URL path in @RequestMapping
	public ProductReview update(@RequestBody ProductReview productReview,@PathVariable int id) throws ProductReviewNotFoundException {
		ProductReview requestedReview = productReviewDAO.read(id);
		if( requestedReview != null ) {
			return productReviewDAO.update(productReview);
		} else {
			throw new ProductReviewNotFoundException(id,"Todo Not Found!");
		}
	}
	
	@DeleteMapping("/{id}") // handle any DELETE requests with an id for the URL path in @RequestMapping
	public void delete(@PathVariable int id) {
		ProductReview requestedReview = productReviewDAO.read(id);
		if( requestedReview != null ) {
			productReviewDAO.delete(id);
		} else {
			throw new ProductReviewNotFoundException(id,"Todo Not Found!");
		}
	}
	
}
