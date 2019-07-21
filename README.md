# spring-multi-datasource
spring-multi-datasource 应用中使用多数据源

项目中使用了两个数据源  

代码核心：  

spring 提供了动态切换数据源的DataSource AbstractRoutingDataSource，可配置个默认的数据源，并且配置一个数据源列表  
Map<Object,Object> targetDataSources = new HashMap<Object,Object>();  
targetDataSources.put("source1",dataSource1);  
targetDataSources.put("source2",dataSource2);  
dynamicDataSource.setTargetDataSources(targetDataSources);  
dynamicDataSource.setDefaultTargetDataSource(dataSource1);  
  
DynamicDataSource继承AbstractRoutingDataSource，并实现自定义获取数据源的标识  
  
自定义注解@DataSource  
  
使用spring aop根据方法上注解的数据源，在调用dao层之前切换数据源  
  
单元测试UserDaoTest  

```text
暂时不支持事务，后续需要继续优化！！！！！可参考文章

切换数据源时判断事务的传播方式
https://blog.csdn.net/lij231/article/details/82934588

springboot+mybatis解决多数据源切换事务控制不生效的问题
https://blog.csdn.net/gaoshili001/article/details/79378902

```


