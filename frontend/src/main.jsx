import React,{useEffect,useState} from 'react'; import {createRoot} from 'react-dom/client'; import './style.css';
function App(){const [items,setItems]=useState([]); useEffect(()=>fetch('http://localhost:8082/api/inventory').then(r=>r.json()).then(setItems).catch(()=>setItems([])),[]);
return <main><h1>Order & Inventory Platform</h1><p>Spring Boot microservices dashboard</p><section><h2>Inventory</h2>{items.map(x=><article key={x.id}>{x.name||'Item'} — {x.quantity||0}</article>)}</section></main>}
createRoot(document.getElementById('root')).render(<App/>);
