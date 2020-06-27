package boot.controller;

import boot.dao.UserDao;
import boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class IndexController {
    @Autowired
    UserDao userDao ;
    @RequestMapping(value = {"/"}, method= RequestMethod.GET)
    public String hello(){
        return "index";
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.POST)
    public User test(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        return new User("admin","123456");
    }
    @RequestMapping(value = "/user_save", method = RequestMethod.POST)
    public Integer save(@PathParam("username") String username, @PathParam("password") String password){
        User user = userDao.save(new User(username,password));
        return user.getId();
    }
}
