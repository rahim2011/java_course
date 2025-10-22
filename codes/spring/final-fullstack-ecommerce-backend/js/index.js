document.getElementById('log-out').addEventListener('click', () => {
    localStorage.removeItem('token');
})


document.getElementById('log-out').addEventListener('click', (e) => {
    localStorage.removeItem('token');

    e.target.textContent="Log in";

    if (!token) {
        window.location.href="login.html";
    }
    else{
    window.location.href="index.html";
    }

}
)