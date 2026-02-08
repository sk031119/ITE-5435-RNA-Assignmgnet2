# SpringBootWebFlux_Assign2_samuel_law

Library Management System built with Spring Boot WebFlux and MongoDB.

## Tech Stack

- Spring Boot 4.0.2 (WebFlux - Reactive)
- Spring Data Reactive MongoDB
- Lombok
- Java 21

## Prerequisites

- Java 21
- MongoDB running on `localhost:27017`
- Maven

## Configuration

Configured in `src/main/resources/application.properties`:

| Property | Value |
|---|---|
| Server Port | `8084` |
| MongoDB Host | `localhost` |
| MongoDB Port | `27017` |
| MongoDB Database | `humber` |

## Entities

Based on the E-R Diagram for Library Management System:

### Book
| Field | Type |
|---|---|
| bookId | String (ID) |
| title | String |
| author | String |
| price | double |
| available | boolean |

### Publisher
| Field | Type |
|---|---|
| pubId | String (ID) |
| name | String |
| address | String |

### Member
| Field | Type |
|---|---|
| membId | String (ID) |
| name | String |
| address | String |
| membType | String |
| membDate | String |
| expiryDate | String |

## API Endpoints

All endpoints return reactive types (`Mono` / `Flux`).

### Book — `/book`

| Method | URL | Description |
|---|---|---|
| GET | `/book` | Get all books |
| GET | `/book/{id}` | Get book by ID |
| POST | `/book` | Create a book |
| PUT | `/book/{id}` | Update a book |
| DELETE | `/book/{id}` | Delete a book |

### Publisher — `/publisher`

| Method | URL | Description |
|---|---|---|
| GET | `/publisher` | Get all publishers |
| GET | `/publisher/{id}` | Get publisher by ID |
| POST | `/publisher` | Create a publisher |
| PUT | `/publisher/{id}` | Update a publisher |
| DELETE | `/publisher/{id}` | Delete a publisher |

### Member — `/member`

| Method | URL | Description |
|---|---|---|
| GET | `/member` | Get all members |
| GET | `/member/{id}` | Get member by ID |
| POST | `/member` | Create a member |
| PUT | `/member/{id}` | Update a member |
| DELETE | `/member/{id}` | Delete a member |

## Sample JSON Payloads

### Book
```json
{
  "bookId": "BK001",
  "title": "Spring in Action",
  "author": "Craig Walls",
  "price": 49.99,
  "available": true
}
```

### Publisher
```json
{
  "pubId": "PUB001",
  "name": "Pearson Education",
  "address": "London, UK"
}
```

### Member
```json
{
  "membId": "MEM001",
  "name": "John Smith",
  "address": "Toronto, Canada",
  "membType": "Student",
  "membDate": "2026-02-07",
  "expiryDate": "2027-02-07"
}
```

## Running

1. Start MongoDB on `localhost:27017`
2. Run the Spring Boot application
3. Test endpoints at `http://localhost:8084`
