import { useState } from "react";

export default function Register() {
    let [reg, setReg] = useState({
        email:"", password:""
    });

    let [msg, setMsg] = useState("");

    function handleEmailChange(e) {
        setReg({...reg, email: e.target.value});

        if (e.target.value.length === 0) {
            setMsg("Email can't be empty!");
        } else {
            setMsg("");
        }
    }

    function handlePasswordChange(e) {
        setReg({...reg, password: e.target.value});

        if (e.target.value.length < 8) {
            setMsg("Password must be at least 8 characters long");
        } else {
            setMsg("");
        }
    }

    function handleSubmit(e) {
        e.preventDefault();

        if (reg.email.trim().length === 0) {
            setMsg("Email can't be empty!");
        }
        else if (reg.password.length < 8) {
            setMsg("Password must be at least 8 characters long");
        }
        else {
            setMsg("User Registered Successfully!");

            setReg({
                email: "",
                password: ""
            });
        }
    }

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="email"
                name="email"
                value={reg.email}
                onChange={handleEmailChange}
                placeholder="Email"
            />

            <input
                type="password"
                name="password"
                value={reg.password}
                onChange={handlePasswordChange}
                placeholder="Password"
            />

            <button type="submit">Submit</button>

            <p>{msg}</p>
        </form>
        );
}