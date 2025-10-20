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