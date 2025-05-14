const loginFrom = document.querySelector('form');

loginFrom.addEventListener('submit', (e) =>{
e.preventDefault();

const request = {
    Username:document.getElementById('Username').value,
    password:document.getElementById('password').value,  
}
    fetch('http://localhost:9999/auth/login',{
        method: 'POST',
        headers: {
'Content-Type': 'application/json'
        },
        body: JSON.stringify(request)
})
  .then(reponse =>{
    if (response.ok){
        const token = response.text();
        localStorage.setItem('token',token);
    }

    else{
       let data = response.json();
        alert(data.message);
    }
  })  
})