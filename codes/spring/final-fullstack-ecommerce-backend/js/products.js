function addProduct() {
    const token = localStorage.getItem('token');

    const productForm = document.querySelector('form');

    productForm.addEventListener('submit', (e) => {
        e.preventDefault();

        const product = {
            name: document.getElementById('product-brand').value,
            model : document.getElementById('product-model').value,
            category: document.getElementById('product-category').value,
            description: document.getElementById('product-description').value,
            price: document.getElementById('product-price').value,
            rating: document.getElementById('product-rating').value,
            image: document.getElementById('product-image').value

        }

        const productId = localStorage.getItem('productId');
 

        if (productId) {
            updateProduct(product,productId);
        } else {
            fetch('http://localhost:8086/products/create', {
                method: 'POST',
                headers: {
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(product)
            })
                .then(response => {
                    if (response.ok) {
                        alert('Product added successfully');
                        document.getElementById('product-brand').value = '';
                        document.getElementById('product-model').value = '';
                        document.getElementById('product-category').value = '';
                         document.getElementById('product-description').value = '';
                        document.getElementById('product-price').value = '';
                        document.getElementById('product-rating').value = '';
                        document.getElementById('product-image').value = '';
                        
                    }
                })
        }
    })
}

addProduct();

function editProduct() {
    const token = localStorage.getItem('token');

    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('id');

    if (productId) {
        localStorage.setItem('productId', productId);

        fetch(`http://localhost:8086/products/getById/${productId}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
            .then(async response => {
                if (response.ok) {
                    const object = await response.json();
                    console.log(object);
                    document.getElementById('product-brand').value = object.brand;
                    document.getElementById('product-model').value = object.model;
                    document.getElementById('product-category').value = object.category;
                    document.getElementById('product-description').value = object.description;                              
                    document.getElementById('product-price').value = object.price;
                    document.getElementById('product-rating').value = object.rating;
                    document.getElementById('product-image').value = object.image;
                }
            })
    }

}

editProduct();

function updateProduct(product,productId) {

    const token = localStorage.getItem('token');

    const productForm = document.querySelector('form');



    productForm.addEventListener('submit', (e) => {
        e.preventDefault();

        fetch('http://localhost:8086/products/update', {
            method: 'PUT',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id:productId,
                brand: product.brand,
                model: product.model,
                category: product.category,
                description: product.description,
                price: product.price,
                rating: product.rating,
                image: product.image
            })
        })
            .then(response => {
                if (response.ok) {
                    alert('product update successfully');
                    localStorage.removeItem('productId');
                    window.location.href = "myProducts.html";
                }
            })
    })
}

const myProductsBtn = document.querySelector('.my-products');

myProductsBtn.addEventListener('click', () => {
    window.location.href = "myProducts.html";
})


document.getElementById('log-out').addEventListener('click', () => {
    localStorage.removeItem('token');
})