
# Spring Data Projections

This is a Spring Boot project using Spring Data Projections.
But, what is Spring Data Projections and why should we use it?

- Spring Data Projections is a feature in the Spring Data framework that allows you to shape query results to fit specific DTOs (Data Transfer Objects) or projection interfaces. Instead of retrieving complete entity objects with all their fields, you can define an interface or a DTO that declares only the subset of data you're interested in.

- This can be useful for optimizing database queries and reducing the amount of data transferred over the network. It also helps in keeping your application more efficient by fetching only the required fields, especially when dealing with large datasets.

There are various types of projections, like so:
- Closed interface
- Open interface
- Class based (POJO) in this project I used Java Records
- Class based using Named Native Query this query should be in the entity class and we have to mapp with a POJO, I used Java Records too.
- Dinamic projection using Java generics



## API Reference


```http
  GET /employee/closed_projection/{id}
```

| Parameter | Return Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `JSON` | Return the name, phone number, and street of the specific employee depending on the **id** using the **closed** interface **EmployeeInfo**. |


```http
  GET /employee/open_projection/{id}
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `JSON` | Return the name, phone number, and street of the specific employee depending on the **id** using the **open** interface **EmployeeFullLocation**.

```http
  GET /employee/class_based_projection/{id}
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `JSON` |  Return the name, phone number, and street of the specific employee depending on the **id** using the **record EmployeeLocationDTO**|

```http
  GET /employee/named_native_query/{id}
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `JSON` |  Return the name, phone number, and street of the specific employee depending on the **id** using the **record EmployeeLocationDTO2**

```http
  GET /employee/dinamic_projection/{id}
```

| Parameter | Return Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `JSON` | Return the name, phone number, and street of the specific employee depending on the **id** using the specific projection, because this method uses **generics**.|