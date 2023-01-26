# Day 17 - Redis

## Problem 1 - Buat REST API ✅

### Criteria
1. Menggunakan redis sebagai media penyimpanan ✅
    - Redis sebagai media penyimpanan primer 
    - Redis sebagai cache
2. Menerapkan fitur autentikasi ✅

| Username | Password |
|----------|----------|
| johndoe  | password |

### Endpoints

**[Postman Documentation 🔗](resources/RedisBook.postman_collection.json)**

| Endpoint     | HTTP Method | Auth Type | Request Body                                                                                                                                                                                                            |
|--------------|-------------|-----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| /auth/signin | POST        | None      | {<br/> "username" : "johndoe", <br/> "password" : "password"<br/>}                                                                                                                                                      |
| /books       | GET         | Bearer    |                                                                                                                                                                                                                         |
| /books/:id   | GET         | Bearer    |                                                                                                                                                                                                                         |
| /books       | POST        | Bearer    | {<br/>"title": "Atomic Habit",<br/> "isbn": " 9780735211292", <br/> "writer": "Clear, James",<br/>"description": "An Easy & Proven Way to Build Good Habits & Break Bad Ones",<br/>"category": "Self Improvement"<br/>} |
| /books/:id   | PATCH       | Bearer    | {<br/>"title": "Atomic Habit",<br/> "isbn": " 9780735211292", <br/> "writer": "Clear, James",<br/>"description": "An Easy & Proven Way to Build Good Habits & Break Bad Ones",<br/>"category": "Self Improvement"<br/>} |
| /books/:id   | DELETE      | Bearer    |                                                                                                                                                                                                                         |
