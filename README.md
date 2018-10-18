# spring-security-example

## 相关技术
- mvn  
- spring-security   
- JWT  
- flyway  
- postgresql  

## 运行
1. psql 中 执行 `resources/seeds.sql`  
2. `mvn clean package`  
3. `mvn spring-boot:run`  
4. 注册     
`POST http://localhost:8080/api/auth/user?username=test_user&password=123456&role=USER`  
`POST http://localhost:8080/api/auth/user?username=test_admin&password=123456&role=ADMIN`  
5. 登录 `POST http://localhost:8080/api/auth?username=test_user&password=123456` 得到token, role是user  
5. 登录 `POST http://localhost:8080/api/auth?username=test_admin&password=123456` 得到token, role是admin  
6. 访问user role资源 `GET http://localhost:8080/home`, 加入header: `Authorization: Bearer ${user token}`  
7. 访问admin role资源 `GET http://localhost:8080/admin`, 加入header: `Authorization: Bearer ${admin token}`  

