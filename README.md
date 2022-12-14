# Mise en oeuvre d'une architecture micro services avec Docker
 
 ## Structure des Projets
 
 ### Billing Service
 
 ![image](https://user-images.githubusercontent.com/84138772/198905816-b3fb3703-3e3b-4718-b1de-ddf15e8b68e0.png)

### Customer Service

![image](https://user-images.githubusercontent.com/84138772/198905859-6ddffb83-04ff-4bca-84d4-de4d744a9747.png)

### Discovry Service 

![image](https://user-images.githubusercontent.com/84138772/198905903-d35c5244-092a-40c6-8459-095662ac85dc.png)

### Gateway Service

![image](https://user-images.githubusercontent.com/84138772/198905928-65ab353b-3c80-4298-b814-7266509de728.png)

## Les entités

* * * 
>	Une entité "Customer" qui comporte les propriétés suivantes :
 - Son id
 - email
 - nom
```java=10
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
}

```

```java=10
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    private String id;
    private Date date;
    private BigDecimal amount;
    private String customerId;
    @Transient
    private Customer customer;
}

```
## Docker

![image](https://user-images.githubusercontent.com/84138772/198905558-742b9ac0-1f48-401a-a62b-2e6639c03e62.png)

![image](https://user-images.githubusercontent.com/84138772/198906151-846857d6-eb02-4e28-85eb-d28914a79c2c.png)

## Teste

### Swagger

![image](https://user-images.githubusercontent.com/84138772/198906200-9872bf9c-a0eb-4946-b8a2-4f5afe709ae7.png)
