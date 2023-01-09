package com.example.academia.course.controller;

import com.example.academia.course.bean.Admin;
import com.example.academia.course.service.AdminService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("login")
public class AdminController {

    AdminService adminService = new AdminService();

    @POST
    @Path("verify")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verify(Admin lObj) {
        Admin loggedInStudent = adminService.verify(lObj);
        if (loggedInStudent == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(loggedInStudent).build();
    }


}
