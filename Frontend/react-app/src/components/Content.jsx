import { useEffect, useState } from "react";
import axios from "axios";

export let Content = () => {
    // let [name, setName] = useState("");
    // let [msg, setMsg] = useState("");

    // useEffect(() => {
    //     var dataString = localStorage.getItem("Users") || "";
    //     var data = dataString.split(",");

    //     if (data.includes(name)) {
    //         setMsg("User already exists");
    //     } else {
    //         setMsg("");
    //     }
    // }, [name]);

    // const storeName = () => {
    //     var currentData = localStorage.getItem("Users");
    //     if(msg === "") {
    //         localStorage.setItem("Users", currentData + "," + name);
    //         setMsg("User added successfully");
    //     }
    // };

    let [products, setProducts] = useState([]);

    const fetchData = async() => {
        var prd = await axios.get("https://fakestoreapi.com/products");
        setProducts(prd.data);
    }

    useEffect(() => {
        fetchData();
    }, [])

    return (
        <>
            {/* <p>Name : {name}</p>
            <input onChange={(e) => setName(e.target.value)}/>
            <button onClick={storeName}>Add Name</button>
            <p>{msg}</p> */}


            {products.map((item) => (
                <div className="card">
                    <h3>{item.title}</h3>
                    <h4>{item.price}</h4>
                    <img src={item.image} />
                </div>
            ))}
        </>
    );
}