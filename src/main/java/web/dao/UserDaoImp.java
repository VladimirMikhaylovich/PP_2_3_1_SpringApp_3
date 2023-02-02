package web.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {

    private static int USER_ID;
    private List<User> userList;
    {
        userList = new ArrayList<>();
        userList.add(new User(++USER_ID, "Alex", "Mrkin", 35));
        userList.add(new User(++USER_ID, "Nail", "Sadukov", 36));
        userList.add(new User(++USER_ID, "Sergej", "Formin", 34));
        userList.add(new User(++USER_ID, "Dimi", "Weselowski", 39));
    }

   public List<User> getUserList(){
        return userList;
    }

   public User getUser(int id){
        return userList.stream().filter(user ->user.getId() == id).findAny().orElse(null);
    }
   public void save(User user){
        user.setId(++USER_ID);
        userList.add(user);
   }
   public  void update(int id, User updatedUser){
        User userToUpdate = getUser(id);
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setLastname(updatedUser.getLastname());
        userToUpdate.setAge(updatedUser.getAge());
   }
   public void delete(int id){
        userList.removeIf(d ->d.getId() == id);
   }
}
