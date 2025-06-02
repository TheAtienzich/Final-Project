# Final-Project (CANDLE STORE MANAGEMENT)

This project consists of a **web interface** for managing a candle store. It features two main user flows:

- **Admin Interface**
- **Client Interface**

Access to each interface is determined by two elements: the user's **email** and the **company code**.

---

## 🧭 THE WELCOME MENU

Upon launch, the application displays a menu asking the user what action they want to take:

- 🔐 **Register**  
- 🔑 **Log In**  
- ❌ **Exit Application**

---

### 📝 REGISTER

The user must input the following information:

- **Name**
- **Surname**
- **Email**
- **Password**

Validation checks:
- Email must include **@gmail.com** or **@hotmail.com**.
- If not valid, the system will request the input again until a valid email is entered.

Once registration is successful, the user is redirected to the **Client Interface**.

---

### 🔓 LOG-IN

The user is prompted to enter their **Email**.

- If the email **contains "@onFire.com"** and the **company code "1234OF"** is entered correctly, the user is **redirected to the Admin Interface** without needing a password.
- Otherwise, the app:
  - Checks if the email exists in the **Users list**.
  - If found, asks for the **Password** and verifies it.
  - If the credentials match, the user is **redirected to the Client Interface**.
  - If not, an error message is shown.

---

## 🧑‍💻 CLIENT INTERFACE

The client interface allows users to interact with the candle store. Available features include:

- 🕯 **View Candle Catalog**
- ➕ **Add Candles to Shopping Cart**
- 🛒 **View Cart**
- 💳 **Purchase Products**
- 🚪 **Logout**


---

## 👨‍💼 ADMIN INTERFACE

The admin interface allows users with admin credentials to manage the store data. Available features include:

- 📦 **Add New Candles to the Store**
- 🧾 **View All Registered Users**
- 🕯 **View/Edit/Delete Existing Candles**
- 📊 **Generate Simple Reports**
- 🚪 **Logout**

This interface allows full control over inventory and user management.

---
- The Admin credentials are any email ending in @onFire.com and the company code 1234OF.


