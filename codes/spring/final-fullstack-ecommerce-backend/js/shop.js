const products = [
      { name: "Hanes Hanes Cotton T-Shirt", category: "Clothing", price: 19.99, image: "https://m.media-amazon.com/images/I/71pP9Z1lAVL._AC_UL480_FMwebp_QL65_.jpg" },
      { name: "Nike Running Shoes", category: "Footwear", price: 69.99, image: "https://static.nike.com/a/images/t_prod_ss/w_960,c_limit,f_auto/i1-7a8028cb-c33f-4e4e-b8bb-5c14d224ed9e/air-zoom-pegasus-40-road-running-shoes.png" },
      { name: "Samsonite Backpack", category: "Accessories", price: 49.99, image: "https://m.media-amazon.com/images/I/71a6wUNvQ5L._AC_UY1000_.jpg" },
      { name: "Apple iPad Pro", category: "Tablets", price: 899.99, image: "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-pro-11-select-wifi-spacegray-202210_FMT_WHH?wid=940&hei=1112&fmt=png-alpha&.v=1664411207206" }
    ];

    function displayProducts(list) {
      const container = document.getElementById('productList');
      container.innerHTML = '';
      list.forEach(p => {
        container.innerHTML += `
          <div class="product">
            <img src="${p.image}" alt="${p.name}">
            <h4>${p.name}</h4>
            <p class="price">$${p.price.toFixed(2)}</p>
            <button class="add-to-cart" onclick="addToCart('${p.name}')">Add to cart</button>
          </div>`;
      });
    }

    function searchProducts() {
      const query = document.getElementById('search').value.toLowerCase();
      const filtered = products.filter(p => p.name.toLowerCase().includes(query));
      displayProducts(filtered);
    }

    function filterCategory(category) {
      const filtered = products.filter(p => p.category === category);
      displayProducts(filtered);
    }

    function addToCart(productName) {
      let cart = JSON.parse(localStorage.getItem('cart')) || [];
      cart.push(productName);
      localStorage.setItem('cart', JSON.stringify(cart));
      alert(`${productName} added to cart!`);
    }

    displayProducts(products);
  