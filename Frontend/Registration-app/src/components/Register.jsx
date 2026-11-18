import { useState } from 'react';
import axios from 'axios';

const Register = ({ onRegisterSuccess, onSwitchToLogin }) => {
  const API = "http://localhost:8080/";

  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
    role: "student"
  });

  const [msg, setMsg] = useState("");

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post(`${API}api/user`, user);
      console.log(res);
      setMsg("Registration successful! You can now login.");
      setUser({
        name: "",
        email: "",
        password: "",
        role: "student"
      });
      if (onRegisterSuccess) {
        onRegisterSuccess();
      }
    } catch (err) {
      console.error(err);
      setMsg(err.response?.data?.message || "Registration failed!");
    }
  };

  return (
    <div>
      <h2>Register</h2>
      {msg && <p>{msg}</p>}

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          value={user.name}
          placeholder="Enter your name..."
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="email"
          name="email"
          value={user.email}
          placeholder="Enter your email..."
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="password"
          name="password"
          value={user.password}
          placeholder="Enter your password..."
          onChange={handleChange}
        />
        <br /><br />

        <label>
          <input
            type="radio"
            name="role"
            value="student"
            checked={user.role === "student"}
            onChange={handleChange}
          />{" "}
          Student
        </label>
        {" "}
        <label>
          <input
            type="radio"
            name="role"
            value="teacher"
            checked={user.role === "teacher"}
            onChange={handleChange}
          />{" "}
          Teacher
        </label>
        <br /><br />

        <button type="submit">Submit</button>
      </form>

      <p>
        Already have an account?{" "}
        <button type="button" onClick={onSwitchToLogin}>
          Login here
        </button>
      </p>
    </div>
  );
};

export default Register;
