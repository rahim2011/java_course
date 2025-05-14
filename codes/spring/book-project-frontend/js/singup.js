 const registerForm = document.querySelector('form');

 registerForm.addEventListener('submit',(event) =>{
    event.preventDefault();

    const user = {
        firstName: document.getElementById('FirstName').value,
        lastName: document.getElementById('LastName').value,
        userName: document.getElementById('Username').value,
        password:document.getElementById('password').value,
        email: document.getElementById('email').value
    }
    fetch('http://localhost:9999/user/register',{
method:'POST',
headers : {
    'Content-Type':'application/json'
},
body: JSON.stringify(user)
    })
    .then(async response => {
if(response.ok){
    const message = await response.text();
    alert(message);
 document.getElementById('FirstName').value ="";
 document.getElementById('LastName').value ="";
 document.getElementById('Username').value ="";
document.getElementById('password').value ="";
 document.getElementById('email').value ="";
}
else{
    const data = await response.json();
    alert(data.message);
}

    })
 })