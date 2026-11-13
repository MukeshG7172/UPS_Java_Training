import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Content } from "./components/Content";
import { Navbar } from "./components/Navbar";
import { Header } from "./components/Header"
import Home from "./Home";
import "./App.css";

function App() {
    return (
        <BrowserRouter>
        <Header/>
        <Navbar/>
            <Routes>
                <Route path="/content" element={<Content />} />
                <Route path="/home" element={<Home />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;