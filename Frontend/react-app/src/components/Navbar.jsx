import { Link } from "react-router-dom"

export const Navbar = () => {
    return(
        <div class="navbar">
            <Link to="/home">Home</Link>
            <Link to="/content">Content</Link>
        </div>
    );
}