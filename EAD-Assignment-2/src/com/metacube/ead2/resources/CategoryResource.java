package com.metacube.ead2.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.ead2.enums.Status;
import com.metacube.ead2.facade.CategoryFacade;
import com.metacube.ead2.factory.BaseFactory;
import com.metacube.ead2.model.Category;

@Path("/Category")
public class CategoryResource {

    CategoryFacade categoryFacade = BaseFactory.createCategoryFacade();
    String key = "get2019";

    @POST
    @Path("/InsertCategory/{categoryID}/{categoryName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Status insertCategory(
            @HeaderParam("Authorization") String authorization,
            @PathParam("categoryID") int categoryID,
            @PathParam("categoryName") String categoryName) {

        if (!key.equals(authorization)) {
            return Status.INVALID;
        }
        Category category = new Category(categoryID, categoryName);
        if (category.getName() != null) {
            return categoryFacade.insertCategory(category);
        } else {
            return Status.NULL_VALUES;
        }
    }

    @GET
    @Path("/GetCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCategories(
            @HeaderParam("Authorization") String authorization) {

        if (!key.equals(authorization)) {
            Gson gson = new Gson();
            String categoryJson = gson.toJson("incorrect Key");
            return categoryJson;
        }

        List<Category> categoryList = categoryFacade.getAll();
        if (categoryList.size() != 0) {
            Gson gson = new Gson();
            String categoryJson = gson.toJson(categoryList);
            return categoryJson;
        }
        return "No Data Present";
    }

    @PUT
    @Path("/UpdateCategory/{categoryID}/{categoryName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Status updateCategory(
            @HeaderParam("Authorization") String authorization,
            @PathParam("categoryID") int categoryID,
            @PathParam("categoryName") String categoryName) {
        if (!key.equals(authorization)) {
            return Status.INVALID;
        }        
        Category category = new Category(categoryID, categoryName);

        if (category.getName() != null) {
            return categoryFacade.updateCategory(category);
        }
        return Status.NULL_VALUES;
    }
}