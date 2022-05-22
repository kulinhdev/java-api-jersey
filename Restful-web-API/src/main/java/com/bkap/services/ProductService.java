package com.bkap.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bkap.dao.ProductDAO;
import com.bkap.entities.Product;
import com.google.gson.Gson;

@Path("/products")
public class ProductService {
	ProductDAO proDAO;
	Gson gson;

	public ProductService() {
		proDAO = new ProductDAO();
		gson = new Gson();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	@GET
	public String getProducts() {
		List<Product> products = proDAO.getAll();

		return gson.toJson(products);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/search/{name}")
	public String search(@PathParam("name") String name) {
		List<Product> products = proDAO.search(name);
		return gson.toJson(products);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String search(@PathParam("id") int id) {
		Product product = proDAO.getById(id);
		return gson.toJson(product);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String data) {
		Product product = gson.fromJson(data, Product.class);
		boolean result = proDAO.insert(product);

		if (result)
			return "{msg:'Add new product success!'}";
		else
			return "{msg:'Add new product failed!'}";
	}

	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String data) {
		Product product = gson.fromJson(data, Product.class);
		boolean result = proDAO.update(product);
		if (result) {
			return "{msg:'Update product success!'}";
		} else {
			return "{msg:'Update product failed!'}";
		}
	}

	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String delete(@PathParam("id") int id) {
		boolean result = proDAO.delete(id);
		if (result) {
			return "{msg:'Delete product success!'}";
		} else {
			return "{msg:'Delete product failed!'}";
		}
	}

}