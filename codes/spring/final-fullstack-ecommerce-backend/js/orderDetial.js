const token = localStorage.getItem('token');

fetch('http://localhost:8086/orders/getOrder', {
  headers: {
    'Authorization': `Bearer ${token}`
  }
})
  .then(res => res.json())
  .then(data => {
    console.log(data);
    const order = data[0];

    document.getElementById('first_name').textContent = order.firstName;
    document.getElementById('last_name').textContent = order.lastName;
    document.getElementById('country').textContent = order.country;
    document.getElementById('address').textContent = order.address;
    document.getElementById('City-Town').textContent = order.city;
    document.getElementById('phone').textContent = order.phone;
    document.getElementById('email').textContent = order.email;
    document.getElementById('cart_number').textContent = order.cartNumber;
    document.getElementById('expiry_month').textContent = order.expiryMonth;
    document.getElementById('expiry_year').textContent = order.expiryYear;
                document.getElementById('zip_code').textContent = order.zipCode;
  })
  .catch(err => console.error(err));