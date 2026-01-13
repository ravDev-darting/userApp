## Project Overview

**App name: UsersApp**
Purpose: Fetch and display users from https://jsonplaceholder.typicode.com/users

### App Overview

The Users App fetches a list of users from a public REST API and displays them in a RecyclerView.  
It focuses on **architecture quality, separation of concerns, and scalability**, rather than UI complexity.


## 🎯 Purpose of This Project

This project demonstrates that I can:

- Build **production-level Android architecture**
- Apply **Clean Architecture principles**
- Manage **UI state using StateFlow**
- Handle **network calls, loading, and error states**
- Write **maintainable, testable, and scalable code**

### Key Features

Kotlin

MVVM + Clean Architecture

Repository pattern

Coroutines + Flow

StateFlow for UI state

Retrofit + OkHttp

RecyclerView (XML UI)

Loading / Success / Error states

Graceful network failure handling

ViewBinding enabled

Single Activity + One Fragment

## **Folder Structure Tree**

UsersApp/
├── app/
│   ├── src/main/java/com/example/usersapp/
│   │   ├── data/
│   │   │   ├── remote/
│   │   │   │   ├── ApiService.kt
│   │   │   │   └── RetrofitClient.kt
│   │   │   ├── mapper/
│   │   │   │   └── UserMapper.kt
│   │   │   ├── model/
│   │   │   │   └── UserDto.kt
│   │   │   └── repository/
│   │   │       └── UserRepositoryImpl.kt
│   │   │
│   │   ├── domain/
│   │   │   ├── model/
│   │   │   │   └── User.kt
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.kt
│   │   │   └── usecase/
│   │   │       └── GetUsersUseCase.kt
│   │   │
│   │   ├── presentation/
│   │   │   ├── ui/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── UsersFragment.kt
│   │   │   │   └── UsersAdapter.kt
│   │   │   └── viewmodel/
│   │   │       ├── UsersViewModel.kt
│   │   │       └── UsersUiState.kt
│   │   │
│   │   └── UsersApplication.kt
│   │
│   ├── src/main/res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── fragment_users.xml
│   │   │   └── item_user.xml
│   │   └── values/
│   │       └── themes.xml
│   │
│   └── AndroidManifest.xml
│
├── gradle/
│   └── libs.versions.toml
├── build.gradle (Project)
├── settings.gradle
└── app/build.gradle



### Layers

- **Presentation** → UI, ViewModel, StateFlow
- **Domain** → Business logic (UseCases, Models)
- **Data** → API, DTOs, Repository implementation

---

## 🛠 Tech Stack

- **Kotlin**
- **MVVM**
- **Clean Architecture**
- **StateFlow**
- **Coroutines**
- **Retrofit**
- **OkHttp**
- **RecyclerView**
- **ViewBinding**
- **Material Design**

---

## 🌐 API Used

https://jsonplaceholder.typicode.com/use



---

## 📸 App Flow

1. App launches
2. Fetches users from API
3. Shows loading state
4. Displays user list
5. Handles error state gracefully

---

## 🚀 How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/ravDev-darting/userApp
