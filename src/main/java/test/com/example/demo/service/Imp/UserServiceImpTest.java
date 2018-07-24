package test.com.example.demo.service.Imp; 

import com.example.demo.SpringBootDemoApplication;
import com.example.demo.pojo.SysUserRole;
import com.example.demo.pojo.User;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserSerevice;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
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

    @Resource(name = "userServiceImpl")
    private UserSerevice userService;

//    该单元测试类不属于Spring管理。无法使用@Autowired注解
//    @Autowired
//    private UserRoleService userRoleService;

    @Resource(name = "userRoleServiceImpl")
    private UserRoleService userRoleService;

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
    String userId=userService.findUserIdByName(userName);
    Set<SysUserRole> roleIdSet=userService.findRoleIdByUid( Integer.parseInt(userId) );
    Set<String> roleSet=new HashSet<>();
    Set<Integer>  pemissionIdSet=new HashSet<>();
    Set<String>  pemissionSet=new HashSet<>();
    for(SysUserRole roleInfo : roleIdSet) {
        int roleId=roleInfo.getRoleId();
        roleSet.add( userService.findRoleByRoleId( roleId  ) );
        //将拥有角色的所有权限放进Set里面，也就是求Set集合的并集
        pemissionIdSet.addAll( userService.findPermissionIdByRoleId(  roleId ));
    }
    for(int permissionId : pemissionIdSet) {
        String  permission=userService.findPermissionById(permissionId).getPermission();
        System.out.println(permission);
        pemissionSet.add(  permission  );
    }
} 

@Test
  public  void testFindRoleIdByUserId()  {
    User user=userService.findRoleIdByUserName("admin");
    assertEquals("管理员",user.getName());
    List<SysUserRole> userRoleList=user.getRoleIdList();
    for(SysUserRole sysUserRole: userRoleList) {
        System.out.println("uid:"+sysUserRole.getUid()+" ,roleId:"+sysUserRole.getRoleId());
    }
  }

  @Test
  public  void testFindUserByRoleId() {
    SysUserRole sysUserRole=userRoleService.findUserByRoleId(1);
    List<User> userList=sysUserRole.getUserIdList();
    for(User user : userList) {
        System.out.println(user.getName()+",userName:"+user.getUserName()+",userId"+user.getUid());
    }

  }


} 
