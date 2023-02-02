package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.models.User;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserDaoImp userDao;

    @Autowired
    public UserController(UserDaoImp userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String getAllUsers(Model model){
      model.addAttribute("users", userDao.getUserList());
      return "users/get_user_list";

    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id, Model model){
        model.addAttribute("user", userDao.getUser(id));
        return "users/get_user";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
         userDao.save(user);
         return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable int id, Model model){
    model.addAttribute("user", userDao.getUser(id));
    return "users/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable int id){
        userDao.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        userDao.delete(id);
        return "redirect:/users";
    }
}
