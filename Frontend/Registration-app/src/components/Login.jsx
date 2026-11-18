import { useState } from 'react';
import axios from 'axios';

const Login = ({ onLoginSuccess, onSwitchToRegister }) => {
  const API = "http://localhost:8080/";

  const [loginData, setLoginData] = useState({
    email: "",
    password: ""
  });

  const [msg, setMsg] = useState("");

  const handleChange = (e) => {
    setLoginData({ ...loginData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post(`${API}api/user/login`, loginData);
      console.log("Logged in user:", res.data);
      onLoginSuccess(res.data);
    } catch (err) {
      console.error(err);
      setMsg(err.response?.data?.message || "Invalid email or password!");
    }
  };

  return (
    <div>
      <h2>Login</h2>
      {msg && <p>{msg}</p>}

      <form onSubmit={handleSubmit}>
        <input
          type="email"
          name="email"
          value={loginData.email}
          placeholder="Enter your email..."
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="password"
          name="password"
          value={loginData.password}
          placeholder="Enter your password..."
          onChange={handleChange}
        />
        <br /><br />

        <button type="submit">Login</button>
      </form>

      <p>
        Don't have an account?{" "}
        <button type="button" onClick={onSwitchToRegister}>
          Register here
        </button>
      </p>
    </div>
  );
};

export default Login;
