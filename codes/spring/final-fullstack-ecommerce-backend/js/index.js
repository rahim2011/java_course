const btn = document.getElementById('log-out');

window.addEventListener('DOMContentLoaded', () => {
    const token = localStorage.getItem('token');
    if (token) {
        btn.textContent = "Log out";
    } else {
        btn.textContent = "Log in";
    }
});

btn.addEventListener('click', (e) => {
    const token = localStorage.getItem('token');
    if (token) {
        localStorage.removeItem('token');
        e.target.textContent = "Log in";
        window.location.href = "login.html";
    } else {
        window.location.href = "login.html";
    }
})