package test.com.example.demo.service.Imp; 

import com.example.demo.SpringBootDemoApplication;
import com.example.demo.pojo.SysRole;
import com.example.demo.pojo.SysUserRole;
import com.example.demo.pojo.User;
import com.example.demo.service.Imp.UserServiceImp;
import com.example.demo.service.UserSerevice;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/** 
* UserServiceImp Tester. 
* 
* @author <Authors name> 
* @since <pre>03/15/2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class UserServiceImpTest {

    @Resource(name = "userServiceImp")
    private UserSerevice userService;

    private String userName="admin";
    private String id="1";

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findUserByName(String name) 
* 
*/ 
@Test
public void testFindUserByName() throws Exception { 
//TODO: Test goes here...
   User user= userService.findUserByName(userName);
    System.out.println(user.toString());
} 

/** 
* 
* Method: showUsers(String uid) 
* 
*/ 
@Test
public void testShowUsers() throws Exception { 
//TODO: Test goes here...
    User user= userService.showUsers("1");
    System.out.println(user.toString());
} 

/** 
* 
* Method: findUserIdByName(String userName) 
* 
*/ 
@Test
public void testFindUserIdByName() throws Exception { 
//TODO: Test goes here...
    String userId= userService.findUserIdByName(userName);
    System.out.println( userId );
} 

/** 
* 
* Method: findRoleIdByUid(int uid) 
* 
*/ 
@Test
public void testFindRoleIdByUid() throws Exception { 
//TODO: Test goes here...
    Set<SysUserRole> roleSet= userService.findRoleIdByUid(1);
    for(SysUserRole role : roleSet) {
        System.out.println(role.getRoleId());
    }
} 

/** 
* 
* Method: findPermissionIdByRoleId(int roleId) 
* 
*/ 
@Test
public void testFindPermissionIdByRoleId() throws Exception { 
//TODO: Test goes here...

    Set<Integer>  permissionSet=userService.findPermissionIdByRoleId(2);
    for(int permissionId : permissionSet) {
        System.out.println(permissionId);
    }
} 

/** 
* 
* Method: findRoleByRoleId(int roleId) 
* 
*/ 
@Test
public void testFindRoleByRoleId() throws Exception { 
//TODO: Test goes here...

    assertEquals(  "vip" ,userService.findRoleByRoleId(2));
} 

/** 
* 
* Method: findPermissionById(int id) 
* 
*/ 
@Test
public void testFindPermissionById() throws Exception { 
//TODO: Test goes here...
    System.out.println(  userService .findPermissionById(1).getPermission()   );
} 


} 
