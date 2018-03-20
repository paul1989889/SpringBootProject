一.收获        <br>
1.熟悉一下SpringBoot;    <br>
2.加强SSM的理解    <br>
3.加强单元测试的运用，断言,配合SpringBoot的注解    <br>
4.

一.待添加功能：    <br>
1.Shiro框架,MD5加密    <br>
2.后端模板freemaker等    <br>
二.遇到的障碍：    <br>
1.Mybatis找不到生成的Mapper对应的Class文件，需要配置Mybatis属性    <br>
2.Spring依赖注入，@Autowired和@Resource的细节    <br>
3.网址中Url的参数，取的值是等号后面的内容，包括引号在内。    <br>
比如，http://localhost:8080/user?name=admin    <br>
4.@Configuration和@Bean    <br>
5.html如何获取后台request中的attribute值?可以通过模板引擎获取    <br>
6.注意@RestController和@Controller的区别，@RestController返回字符串时会直接显示文本，而不是跳转到对应的页面     <br>
7.UserRealm中注入service对象报空指针?原因是在ShiroConfig中，没有注入realm  <br>
8.shiro过滤器filterChainDefinitionMap，具体如何配置？   <br>