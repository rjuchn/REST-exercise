package com.juchnicki.resources;

import com.juchnicki.model.Message;
import com.juchnicki.model.TestClass;
import com.juchnicki.resources.beans.MessageFilterBean;
import com.juchnicki.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Rafal on 2016-12-04.
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService messageService = new MessageService();

//    @Autowired
//    TestClass test;
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    TestClass test = (TestClass) context.getBean("test");
    //BeanParam type of access the query parameters
    @GET
    @Path("/test")
    public String getTest() {
        return this.test.getText();
    }
    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBeanbean){
        if(filterBeanbean.getYear() > 0) {
            return messageService.getAllMessagessForYear(filterBeanbean.getYear());
        }
        if(filterBeanbean.getStart() >= 0 && filterBeanbean.getSize() >= 0 ){
            return messageService.getAllMessagesPaginated(filterBeanbean.getStart(),
                    filterBeanbean.getSize());
        }
        return messageService.getAllMessages();
    }
//    @GET
//    public List<Message> getMessages(@QueryParam("year") int year,
//                                     @QueryParam("start") int start,
//                                     @QueryParam("size") int size){
//        if(year > 0) {
//            return messageService.getAllMessagessForYear(year);
//        }
//        if(start >= 0 && size >= 0 ){
//            return messageService.getAllMessagesPaginated(start, size);
//        }
//        return messageService.getAllMessages();
//    }

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/test")
//    public String test(){
//        return "test";
//    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }

    @POST
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id,  Message message){
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) {
        messageService.removeMessage(id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
}
