fetch('http://localhost:8086/orders/getOrder')
  .then(res => res.json())
  .then(data => {
    console.log(data); 
    const order = data[0];
    
    document.getElementById('firstName').textContent = order.firstName;
    document.getElementById('lastName').textContent = order.lastName;
    document.getElementById('country').textContent = order.country;
    document.getElementById('address').textContent = order.address;
    document.getElementById('city').textContent = order.city;
    document.getElementById('phone').textContent = order.phone;
    document.getElementById('email').textContent = order.email;
  })
  .catch(err => console.error(err));