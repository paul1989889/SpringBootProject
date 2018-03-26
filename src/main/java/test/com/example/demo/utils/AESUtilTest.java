package test.com.example.demo.utils; 

import com.example.demo.utils.AESUtil;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AESUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>03/23/2018</pre> 
* @version 1.0 
*/ 
public class AESUtilTest { 
  private   String account="admin";
  private   String password="123456";
  private   String key="12345678";
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: encrypt(String content, String password) 
* 
*/ 
@Test
public void testEncrypt() throws Exception { 
//TODO: Test goes here...
    System.out.println(AESUtil.encrypt(password,key));
} 

/** 
* 
* Method: decrypt(String content, String password) 
* 
*/ 
@Test
public void testDecrypt() throws Exception { 
//TODO: Test goes here...
    String encrypt=AESUtil.encrypt(password,key);
    System.out.println(encrypt);
    System.out.println(   AESUtil.decrypt(encrypt,key));
} 


/** 
* 
* Method: getSecretKey(final String password) 
* 
*/ 
@Test
public void testGetSecretKey() throws Exception { 
//TODO: Test goes here...


/* 
try { 
   Method method = AESUtil.getClass().getMethod("getSecretKey", final.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
