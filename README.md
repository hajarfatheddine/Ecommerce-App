# Ecommerce-Application-Project

This repository contains all the components that make the Ecommerce App.

#### The backEnd section:
- **Technical microservices:**
    - eureka-discovery
    - gateway service
    - authentication-service
- **Functional microservices:**
    - customer-service
    - inventory-service
    - billing-service
    - billing-supplier-service
    - kafka-stream-data-analytics
    
#### The FrontEnd section:
- Angular client
- data analytics front

This project was divided into Two parts:
- The first part covered the creation and implementation of:
      **eureka-discovery
      - gateway service
      - authentication-service 
      - customer-service
      - inventory-service
      - billing-service.**
      
- The second part focused on the creation and implementation of : **billing-supplier-service - kafka streams data analytics**

![image](https://user-images.githubusercontent.com/84817425/213583740-4b9b32a5-47b5-4938-bb56-d78c01443868.png)

## PART ONE
## I- THE BACKEND
## 1. Eureka discovery
It is a registration service that allows services to find and communicate with each other without hard-coding the hostname and port.
It contains all the addresses of the microservices.
Use the following URL to access eureka discovery : <https://localhost:8761>

![image](https://user-images.githubusercontent.com/84817425/209443317-550e9346-cb2c-481e-aeb9-bfe69d3d7d6e.png)

## 2. Gateway service
It is a proxy that uses an API with non-blocking I/O.
It receives external requests, and for each request received, it calls the right microservice.

## 3. Customer service
This microservice concerns everything that is customer management.
You can consult the list of all the customers and all the detailed information of each customer.

### - List of all customers:
To access the customers list through the Gateway service, we need to type: <http://localhost:8888/CUSTOMER-SERVICE/customers>

![image](https://user-images.githubusercontent.com/84817425/209443429-477202b4-418d-4ee8-9479-143871996367.png)

### - Customer details:
To access the customer's details through the Gateway service, we need to type: <http://localhost:8888/CUSTOMER-SERVICE/customers/{customerId}>

![image](https://user-images.githubusercontent.com/84817425/209443508-97545d2c-a738-4c5e-b6fb-50684b8906b3.png)

## 4. Inventory service
This microservice concerns everything that is product management.
You can consult the list of all the products and all the detailed information of each product.

### - List of all products:
To access the products list through the Gateway service, we need to type: <http://localhost:8888/INVENTORY-SERVICE/products>

![image](https://user-images.githubusercontent.com/84817425/209443552-685410c6-c40c-4b19-877c-4266c1910350.png)

### - Product details:
To access the product's details through the Gateway service, we need to type: <http://localhost:8888/INVENTORY-SERVICE/products/{productId}>

![image](https://user-images.githubusercontent.com/84817425/209443566-4873fc5c-0ef0-4bcb-bd32-73723e93929e.png)

## 5. Billing service
This microservice concerns everything that is billing.
You can consult the list of all the bills that exist, the details of each bill and the bills of a specific customer.

### - List of all bills:
To access the bills list through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/bills>

![image](https://user-images.githubusercontent.com/84817425/209443599-e43bb401-8696-491f-a5ca-bbd767ba51a2.png)

### - Bill details:
To access a specific bill infos through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/bills/{billId}>

![image](https://user-images.githubusercontent.com/84817425/209443611-f0586a9f-02a9-40cd-a19f-759344eecaf1.png)

### - Bills of a specific customer:
To access the bills of a specific customer through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/customerBills/{customerId}>

![image](https://user-images.githubusercontent.com/84817425/209443752-1c8b4a38-9e9f-4027-957f-1ed68dc6331b.png)

### - Full details of a specific bill:
To access the full details of specific bill through the Gateway service, we need to type: <http://localhost:8888/BILLING-SERVICE/fullBill/{billId}>

![image](https://user-images.githubusercontent.com/84817425/209443771-088eeea2-e8ab-4f2c-b43e-6f2a973acbad.png)

## II- THE FRONTEND
## 1. Products
In this section, the user can view the list of products that exist:
- the product name
- the product price
- the quantity of the product in stock

![products-list-front](https://user-images.githubusercontent.com/84817425/209433679-4e1cece3-e45c-421f-b0cf-8f63e24eac15.png)
## 2. Customers
In this section, the user can view the list of customers that exist:
- the customer full name
- the customer email

![customers-list-front](https://user-images.githubusercontent.com/84817425/209433691-8bac982d-3936-4e0e-9e61-36a3e2e18eea.png)
### - Account Details:
From the list of customers, the user can view the account details of each customer, by clicking on the "Account details" button.

![customer-details](https://user-images.githubusercontent.com/84817425/209433736-817458a1-8e27-484f-ad66-8dab1e673c90.png)
## 3. Bills:
The user can also view the list of bills of each customers by clicking on the "Bills" button.

![customer-bills](https://user-images.githubusercontent.com/84817425/209433753-ad7b770a-12bd-4477-88a2-f258f2570fa9.png)
### - Bills Details:
The user can also view the bill details, meaning the list of products purchased, their quantity and price, by clicking on the "bill details" button.

![bill-details](https://user-images.githubusercontent.com/84817425/209433757-672242cd-67f3-4849-a26a-084108889fb2.png)

## III- SECURITY USING KEYCLOAK

Keycloak is an open source **identity and access management** solution.

###  a. Setting Up a Keycloak Server
To be able to use it to secure our application, we must configure it.
To do so:
- we created a realm called **"Ecom-realm"**, and added the clients which are the applications to secure.

![Capture d’écran (325)](https://user-images.githubusercontent.com/84817425/211005467-0e6e0979-3ba7-4450-9255-01cba6462c9b.png)

- we added the different users.

![image](https://user-images.githubusercontent.com/84817425/209444605-4da7fdc4-4771-4fde-a103-9c510cfd8c18.png)

- we added the different roles that we need and assign them to each corresponding user.

![Capture d’écran (315)](https://user-images.githubusercontent.com/84817425/210899346-64849336-6b10-47f5-851f-e10d59bfb5fb.png)

#### Testing the different authentication modes using Postman
##### Using the access token 
To do so:

- We made a POST request to the token endpoint of the Keycloak server. <http://localhost:8080/realms/Ecom-realm/protocol/openid-connect/token>
- In the "Body" tab, we selected the "x-www-form-urlencoded" option, and then we added the following key-value pairs to the request:
   - "username".
   - "password".
   - "grant_type": password
   - "client_id": (The client ID of your application)

![Capture d’écran (317)](https://user-images.githubusercontent.com/84817425/210899597-80a1d7d6-840f-40c5-ac61-c80769afcf09.png)

##### Using the refresh token
To do so:

1. We made a POST request to the token endpoint of the Keycloak server. <http://localhost:8080/realms/Ecom-realm/protocol/openid-connect/token>
2. In the "Body" tab, we selected the "x-www-form-urlencoded" option, and then we added the following key-value pairs to the request:
   - "username".
   - "password".
   - "grant_type": refresh_token
   - "refresh_token": (the refresh token to refresh/retrieve a new the access token)

![Capture d’écran (321)](https://user-images.githubusercontent.com/84817425/210899660-628693e3-8d04-4a09-9aed-1922c200d1bf.png)

### b. Securing the microservices

To secure each microservices we took the following steps:
1. we added the following dependencies in **`pom.xml`**
```xml		
<dependency> 
    <groupId>org.keycloak</groupId>
    <artifactId>keycloak-spring-boot-starter</artifactId>
    <version>20.0.1</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>		
    <version>2.7.7</version>
</dependency>
```
2. we added keycloak configuration in **`application.properties`** :
```
keycloak.realm=Ecom-realm
keycloak.resource=EcommerceApp
keycloak.bearer-only=true
keycloak.auth-server-url=http://localhost:8080
keycloak.ssl-required=none
```
3. We then added configuration classes inside of the **`security`** package.
  - We created the **`KeycloakAdapterConfig`** class to easily integrate Keycloak with our application.
 ```java 
 @Configuration
public class KeycloakAdapterConfig {
    @Bean
    KeycloakSpringBootConfigResolver springBootConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }
}
 ```
 - We created **`KeycloakSecurityConfig`** class to configure the security settings for our application that is protected by Keycloak. In this class we did override the configure(HttpSecurity) method to specify the security constraints for our application. 
For example: 
 ```java
@Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/customers/{id}").permitAll();
        http.authorizeRequests().antMatchers("/customers").hasAuthority("ADMIN");
        http.headers().frameOptions().disable();
        http.authorizeRequests().anyRequest().authenticated();

    }
 ```
 In this example, everyone has the right to access the endpoint **"/customers/{id}"**, and only the user with the role **"ADMIN"** can access the customers list.
 
 To test this, we sent the following requests with the access token of a user with the role **"CUSTOMER"** using postman: 
 <http://localhost:8888/CUSTOMER-SERVICE/customers>

![Capture d’écran (322)](https://user-images.githubusercontent.com/84817425/211001992-9c45e908-54fa-4d53-9a56-c87d58ccbfce.png)

Because the current user is a CUSTOMER and not an ADMIN, his request is denied.

<http://localhost:8888/CUSTOMER-SERVICE/customers/1>

![Capture d’écran (324)](https://user-images.githubusercontent.com/84817425/211002386-47f179bd-f876-4a4b-8625-e18c171a2385.png)

### c. Securing the frontEnd

To do so, we followed the following steps:
1. We installed the following packages:
```cmd
npm install keycloak-js keycloak-angular
```
The keycloak-js and keycloak-angular packages are libraries that provide integration between Keycloak and JavaScript or Angular applications.

2. We then did set up the keycloak service in the **AppModule**.
```typescript
import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
...
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import {NavbarComponent} from "./components/navbar/navbar.component";

export function kcFactory(kcService:KeycloakService){
  return()=>{
    kcService.init({
      config:{
        realm:"Ecom-realm",
        clientId:"EcommerceApp",
        url:"http://localhost:8080"
      },
      initOptions:{
        onLoad: "check-sso",
        checkLoginIframe:true
      }
    })
  }
}
@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    AccountDetailsComponent,
    BillsComponent,
    BillDetailsComponent,
    NavbarComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      deps:[KeycloakService],
      useFactory:kcFactory,
      multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
3. next, we added the "AuthGard" class:
```typescript
import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  Router,
  RouterStateSnapshot
} from '@angular/router';
import { KeycloakAuthGuard, KeycloakService } from 'keycloak-angular';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard extends KeycloakAuthGuard {
  constructor(
    protected override readonly router: Router,
    protected readonly keycloak: KeycloakService
  ) {
    super(router, keycloak);
  }
  public async isAccessAllowed(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ) {
    // Force the user to log in if currently unauthenticated.
    if (!this.authenticated) {
      await this.keycloak.login({
        redirectUri: window.location.origin + state.url
      });
    }

    // Get the roles required from the route.
    const requiredRoles = route.data["roles"];

    // Allow the user to proceed if no additional roles are required to access the route.
    if (!(requiredRoles instanceof Array) || requiredRoles.length === 0) {
      return true;
    }

    // Allow the user to proceed if all the required roles are present.
    return requiredRoles.every((role) => this.roles.includes(role));
  }
}
```
the AuthGuard is a class that implements the **CanActivate** interface from the Angular router. It is used to protect routes in an Angular application, allowing only authenticated users to access certain routes.

4. we did set up a security service :
```typescript
import {Injectable} from "@angular/core";
import {KeycloakProfile} from "keycloak-js";
import {KeycloakEventType, KeycloakService} from "keycloak-angular";

@Injectable({providedIn: "root"})
export class SecurityService{
  public profile? : KeycloakProfile;
  constructor(public kcService: KeycloakService) {
    this.init();
  }
  init(){
    this.kcService.keycloakEvents$.subscribe({
      next:(e)=>{
        if(e.type== KeycloakEventType.OnAuthSuccess){
          this.kcService.loadUserProfile().then(profile=>{
            this.profile=profile;
          });
        }
      }
    });
  }
  public hasRoleIn(roles: string[]):boolean{
    let userRoles=this.kcService.getUserRoles();
    for(let role of roles){
      if(userRoles.includes(role)) return true;
    }return false;
  }
}
```
This service contains a method to set up and load the user profile and another one to check whether a user has  any of the roles passed to the method as an argument. 

---
The next step that we took is adding the Login/Logout options in the navbar:

![Capture d’écran (331)](https://user-images.githubusercontent.com/84817425/211051879-0b2df5b7-7ac2-44be-b228-52d28bc4cc89.png)

As you may notice, the products & customers elements that were previously visible are not now until the user is authenticated.

![Capture d’écran (340)](https://user-images.githubusercontent.com/84817425/211056770-65688d50-ab68-4e7b-9660-9b892178a6b6.png)

Once the user is authenticated, the navbar look something like this:

![Capture d’écran (337)](https://user-images.githubusercontent.com/84817425/211053109-059c3003-04c6-40e7-93fc-7f8fdadea16f.png)

The user with the role **"ADMIN"** can view both the list of customers as well as the list of products:
 
![Capture d’écran 2023-01-06 172910](https://user-images.githubusercontent.com/84817425/211055135-60b1136e-ae6a-452f-a780-de515e533616.png)
 
The user with the role **"CUSTOMER"** can only view the list of products for now:

![Capture d’écran (338)](https://user-images.githubusercontent.com/84817425/211054489-ed611b4e-b8fe-4131-98be-0d201a3c639a.png)

## PART TWO
## 1. kafka integration

**Dowloading kafka**: <https://kafka.apache.org/downloads>

**Starting kafka**:

To start Kafka, here is the list of the command needed to run in the commad line:

- To start the zookeeper, I ran the following commands:
`````
cd C:/Tools/kafka
start bin\windows\zookeeper-server-start.bat config/zookeeper.properties
`````
- To start the kafka server, I ran the following command:
````
start bin\windows\kafka-server-start.bat config/server.properties
````
## 2. billing-supplier-service

**`billing-supplier-service`** Is a microservice that randomly produce invoices and publish them in a KAFKA topic.
The steps followed to implement it are:
- Adding the following dependencies:
    - lombok
    - spring web
    - spring for apache kafka
    - spring for apache kafka streams
    - cloud stream

- Creating the **`Bill`** class
- Creating the **`ProductItem`** class
- Creating the **`BillSupplier`** in **`BillsSupplierService.java`** to randomly produce and send bills to the R5 topic. 
- Adding the following configuration in `application.properties`to set the destination for sending messages:
```
spring.cloud.stream.bindings.billSupplier-out-0.destination=R5
spring.cloud.function.definition=billSupplier;
spring.cloud.stream.poller.fixed-delay=3000
```
- Creating the **`BillConsymer`** in **`BillService.java`** in the **`billing-service`** to receive the bills and save them to the database.
- Adding the following configuration in `application.properties`to set the destination for sending messages:
```
spring.cloud.stream.bindings.billsConsumer-in-0.destination=R5
spring.cloud.function.definition=billsConsumer
```

 To test this, I executed the following command:
 ```
 > start bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic R5
 ```
This resulted in:

![image](https://user-images.githubusercontent.com/84817425/213742181-311f876b-ab23-4aa6-b089-1ee335dba83a.png)

![image](https://user-images.githubusercontent.com/84817425/213743141-bf007857-ff35-43c6-baee-e1e4da82dd85.png)

