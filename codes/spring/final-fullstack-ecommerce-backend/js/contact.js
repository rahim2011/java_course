function addContact() {
    const token = localStorage.getItem('token');
}
registerForm.addEventListener('submit', (e) => {
    e.preventDefault();
    
    const user = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value,
        message: document.getElementById('message').value
    }
    
})


/*Log out buttonu */
document.getElementById('log-out').addEventListener('click', (e) => {
    localStorage.removeItem('token');

    e.target.textContent="Log in";

    if (!token) {
        window.location.href="login.html";
    }
    else{
    window.location.href="shop.html";
    }

}
)
