/* ===== Simple product dataset ===== */
const PRODUCTS = [
  { id: 'p1', name: 'Tropical One-Piece', price: 49, img: 'https://images.unsplash.com/photo-1503342217505-b0a15d3b4ae2?q=80&w=900&auto=format&fit=crop' },
  { id: 'p2', name: 'Striped Bikini', price: 39, img: 'https://images.unsplash.com/photo-1503341455253-b2e723bb3dbb?q=80&w=900&auto=format&fit=crop' },
  { id: 'p3', name: 'Beach Shorts', price: 29, img: 'https://images.unsplash.com/photo-1491553895911-0055eca6402d?q=80&w=900&auto=format&fit=crop' },
  { id: 'p4', name: 'Sun Hat', price: 25, img: 'https://images.unsplash.com/photo-1520975917596-4b9d82df2a3f?q=80&w=900&auto=format&fit=crop' },
  { id: 'p5', name: 'Beach Towel', price: 19, img: 'https://images.unsplash.com/photo-1510552776732-03e61cf4b144?q=80&w=900&auto=format&fit=crop' },
  { id: 'p6', name: 'Flip Flops', price: 15, img: 'https://images.unsplash.com/photo-1526178613543-2d4a646ef3b8?q=80&w=900&auto=format&fit=crop' },
  { id: 'p7', name: 'Sunglasses', price: 35, img: 'https://images.unsplash.com/photo-1519494026890-9f00ec3af8f0?q=80&w=900&auto=format&fit=crop' },
  { id: 'p8', name: 'Beach Bag', price: 45, img: 'https://images.unsplash.com/photo-1508609349937-5ec4ae374ebf?q=80&w=900&auto=format&fit=crop' }
];

const getEl = sel => document.querySelector(sel);
const getAll = sel => Array.from(document.querySelectorAll(sel));

/* ===== Slider ===== */
function initSlider(){
  const slider = getEl('#heroSlider');
  const slides = getAll('.slide');
  const dotsWrap = getEl('#sliderDots');
  let current = 0;
  let timer;

  function renderDots(){
    dotsWrap.innerHTML = '';
    slides.forEach((_, i) => {
      const dot = document.createElement('div');
      dot.className = 'slider-dot' + (i === 0 ? ' active' : '');
      dot.addEventListener('click', ()=> goTo(i));
      dotsWrap.appendChild(dot);
    });
  }

  function show(i){
    slides.forEach((s, idx) => s.classList.toggle('active', idx === i));
    getAll('.slider-dot').forEach((d, idx) => d.classList.toggle('active', idx === i));
    current = i;
  }

  function next(){ show((current + 1) % slides.length) }
  function prev(){ show((current - 1 + slides.length) % slides.length) }
  function goTo(i){ show(i); resetTimer(); }

  getEl('.slider-nav.prev').addEventListener('click', ()=>{ prev(); resetTimer(); });
  getEl('.slider-nav.next').addEventListener('click', ()=>{ next(); resetTimer(); });

  function startTimer(){ timer = setInterval(next, 4200); }
  function resetTimer(){ clearInterval(timer); startTimer(); }

  renderDots(); startTimer();
  slider.addEventListener('mouseenter', ()=> clearInterval(timer));
  slider.addEventListener('mouseleave', startTimer);
}

/* ===== Render products ===== */
function renderProducts(list){
  const grid = getEl('#productsGrid');
  grid.innerHTML = '';
  list.forEach(p => {
    const card = document.createElement('div');
    card.className = 'product-card';
    card.innerHTML = `
      <img src="${p.img}" alt="${p.name}">
      <div class="product-info">
        <div>
          <div class="p-name">${p.name}</div>
          <div class="p-sub muted">Best choice</div>
        </div>
        <div>
          <div class="price">$${p.price}</div>
          <button class="btn add-cart" data-id="${p.id}" data-name="${p.name}" data-price="${p.price}">Add</button>
        </div>
      </div>
    `;
    grid.appendChild(card);
  });
}

/* ===== Cart (localStorage) ===== */
const CART_KEY = 'eshop_cart_v2';
function loadCart(){ try{ const r = localStorage.getItem(CART_KEY); return r ? JSON.parse(r) : {}; }catch(e){return{}} }
function saveCart(cart){ localStorage.setItem(CART_KEY, JSON.stringify(cart)); }

function updateCartCount(){
  const cart = loadCart();
  const count = Object.values(cart).reduce((s,i)=> s + i.qty, 0);
  getEl('#cartCount').textContent = count;
}

/* open/close cart */
function openCart(){
  getEl('#cartPanel').classList.add('open');
  getEl('#overlay').classList.add('show');
  renderCartItems();
}
function closeCart(){
  getEl('#cartPanel').classList.remove('open');
  getEl('#overlay').classList.remove('show');
}

/* render cart items */
function renderCartItems(){
  const cart = loadCart();
  const container = getEl('#cartItems');
  container.innerHTML = '';
  let total = 0;
  for(const id in cart){
    const item = cart[id];
    total += item.price * item.qty;
    const node = document.createElement('div');
    node.className = 'cart-item';
    node.innerHTML = `
      <img src="${item.img}" alt="${item.name}">
      <div style="flex:1">
        <div style="font-weight:600">${item.name}</div>
        <div style="color:#666">$${item.price} • Qty: <span class="item-qty">${item.qty}</span></div>
        <div style="margin-top:8px">
          <button class="btn dec" data-id="${id}">-</button>
          <button class="btn inc" data-id="${id}">+</button>
          <button class="btn remove" data-id="${id}" style="background:#eee;color:#222;margin-left:8px">Remove</button>
        </div>
      </div>
    `;
    container.appendChild(node);
  }
  getEl('#cartTotal').textContent = total.toFixed(2);

  getAll('.inc').forEach(b => b.addEventListener('click', e=>{
    const id = e.currentTarget.dataset.id;
    const cart = loadCart();
    if(cart[id]){ cart[id].qty += 1; saveCart(cart); renderCartItems(); updateCartCount(); }
  }));
  getAll('.dec').forEach(b => b.addEventListener('click', e=>{
    const id = e.currentTarget.dataset.id;
    const cart = loadCart();
    if(cart[id]){ cart[id].qty = Math.max(1, cart[id].qty - 1); saveCart(cart); renderCartItems(); updateCartCount(); }
  }));
  getAll('.remove').forEach(b => b.addEventListener('click', e=>{
    const id = e.currentTarget.dataset.id;
    const cart = loadCart(); delete cart[id]; saveCart(cart); renderCartItems(); updateCartCount();
  }));
}

/* ===== Add to cart behavior (delegated) ===== */
function attachAddToCart(){
  document.body.addEventListener('click', e=>{
    const btn = e.target.closest('.add-cart');
    if(!btn) return;
    const id = btn.dataset.id || 'temp-'+Date.now();
    const name = btn.dataset.name || 'Product';
    const price = Number(btn.dataset.price) || 0;
    const product = PRODUCTS.find(p => p.id === id) || { img: btn.closest('.product-card')?.querySelector('img')?.src || '', name, price };

    const cart = loadCart();
    if(cart[id]) cart[id].qty += 1;
    else cart[id] = { id, name, price, qty: 1, img: product.img || '' };

    saveCart(cart);
    updateCartCount();

    // feedback
    btn.textContent = 'Added ✓';
    btn.disabled = true;
    setTimeout(()=>{ btn.textContent = 'Add'; btn.disabled = false; }, 900);
  });
}

/* ===== Search & Sort ===== */
function initSearchSort(){
  const search = getEl('#searchInput');
  const sort = getEl('#sortSelect');

  function filterAndRender(){
    const q = search.value.trim().toLowerCase();
    let list = PRODUCTS.filter(p => p.name.toLowerCase().includes(q));
    const s = sort.value;
    if(s === 'price-asc') list = list.slice().sort((a,b)=>a.price-b.price);
    if(s === 'price-desc') list = list.slice().sort((a,b)=>b.price-a.price);
    if(s === 'name-asc') list = list.slice().sort((a,b)=>a.name.localeCompare(b.name));
    renderProducts(list);
  }

  search.addEventListener('input', filterAndRender);
  sort.addEventListener('change', filterAndRender);

  filterAndRender();
}

/* ===== Basic UI init ===== */
function initUI(){
  getEl('#cartBtn').addEventListener('click', openCart);
  getEl('#closeCart').addEventListener('click', closeCart);
  getEl('#overlay').addEventListener('click', closeCart);
  getEl('#checkoutBtn').addEventListener('click', ()=>{
    alert('Checkout demo — thank you!');
    localStorage.removeItem(CART_KEY);
    updateCartCount();
    renderCartItems();
    closeCart();
  });

  // Fake "username stored" behavior
  const storedUser = localStorage.getItem('eshop_user') || 'username';
  getEl('#usernameText').textContent = storedUser;

  // Logout button clears that fake user
  getEl('#logoutBtn').addEventListener('click', ()=>{
    localStorage.removeItem('eshop_user');
    getEl('#usernameText').textContent = 'username';
    // visual feedback
    getEl('#logoutBtn').textContent = 'Logged out';
    setTimeout(()=> getEl('#logoutBtn').textContent = 'Log out', 900);
  });
}

/* ===== On DOM ready: start everything ===== */
document.addEventListener('DOMContentLoaded', ()=>{
  initSlider();
  renderProducts(PRODUCTS);
  attachAddToCart();
  initSearchSort();
  initUI();
  updateCartCount();
  getEl('#year').textContent = new Date().getFullYear();
});
