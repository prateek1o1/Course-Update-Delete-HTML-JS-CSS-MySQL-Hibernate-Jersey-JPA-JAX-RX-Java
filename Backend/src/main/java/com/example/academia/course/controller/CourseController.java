package com.example.academia.course.controller;

import com.example.academia.course.bean.Prerequisite;
import com.example.academia.course.service.CoursesService;
import com.example.academia.course.bean.Courses;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("course")
public class CourseController {

    CoursesService coursesService = new CoursesService();

    @GET
    @Path(  "list")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourse()
    {
        List<String> courseList = coursesService.getList();
        return Response.ok().entity(courseList).build();
    }

    @DELETE
    @Path( "/oblivion/{courseID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourse(@PathParam("courseID") int courseID)
    {
        boolean deletion = coursesService.deleteCourse(courseID);
        if (deletion==false)
            return Response.status(401).build();
        else
            return Response.ok().entity(true).build();
    }

    @PUT
    @Path( "/update/{courseID}/{updatedName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateCourseName(@PathParam("courseID") int courseID,@PathParam("updatedName") String updatedName)
    {
        boolean updated = coursesService.UpdateCourseName(courseID,updatedName);
        if (updated == false)
            return Response.status(401).build();
        else
            return Response.ok().entity(true).build();
    }

    @PUT
    @Path( "/change/{courseID}/{capacity}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateCourseID(@PathParam("courseID") int courseID,@PathParam("capacity") int newID)
    {
        boolean updated = coursesService.UpdateCapacity(courseID,newID);
        if (updated == false)
            return Response.status(401).build();
        else
            return Response.ok().entity(true).build();
    }

//    @POST
//    @Path( "/change")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response UpdateCourse(Courses courObj)
//    {
//        boolean updated = coursesService.UpdateCourse(courObj);
//        if (updated == false)
//            return Response.status(401).build();
//        else
//            return Response.ok().entity(true).build();
//    }

}
