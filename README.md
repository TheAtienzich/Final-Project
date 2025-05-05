# Final-Project  (CANDLE STORE MANAGMENT)
This project consist in a "web interface" that can be in 2 forms:  
Admin Interface & Client Interface    
We will access each one deppending in 2 elements; the email, and the company code.
##


## THE WELCOME MENU
We will ask what the user wants to do:
- Register
- Log In
- Exit Application

### REGISTER
The user will input his **NAME**, **SURNAME**, **EMAIL**, **PASSWORD**.  
We will check if the email contains either @gmail, or @hotmail, if not, we will ask again for the user's data until its introduced correctly.  
Then we will redirect the user to the Client Interface.

### LOG-IN
We will ask the user for his **EMAIL.  
We will search this email in our List of Users\*, if it matches anyone's email, we will ask for his password, if not, we will throw an error message saying it does not exist in the database.  
For the password we will simply compare the user's password with the once introduced and if it matches, we will redirect the user to the Client Interface.  
If the email contains "**@onFire.com**", and introduce the company code ("1234OF") *We will not ask for any password*, we redirect the user to the Admin Interface.  
