import { useState, useEffect } from 'react';
import axios from 'axios';

const TeacherDashboard = ({ user, onLogout }) => {
  const API = "http://localhost:8080/";

  const [students, setStudents] = useState([]);
  const [newStudent, setNewStudent] = useState({
    name: "",
    email: "",
    password: "",
    role: "student"
  });
  const [msg, setMsg] = useState("");

  const loadStudents = async () => {
    try {
      const res = await axios.get(`${API}api/user`);
      setStudents(res.data);
    } catch (err) {
      console.error("Error loading students:", err);
    }
  };

  useEffect(() => {
    loadStudents();
  }, []);

  const handleChange = (e) => {
    setNewStudent({ ...newStudent, [e.target.name]: e.target.value });
  };

  const handleAddStudent = async (e) => {
    e.preventDefault();
    try {
      await axios.post(`${API}api/user`, newStudent);
      setMsg("Student added successfully!");
      setNewStudent({
        name: "",
        email: "",
        password: "",
        role: "student"
      });
      loadStudents();
    } catch (err) {
      console.error(err);
      setMsg(err.response?.data?.message || "Failed to add student!");
    }
  };

  return (
    <div>
      <h2>Teacher Dashboard</h2>
      <p>Welcome, <b>{user.name}</b> ({user.email})</p>
      <button onClick={onLogout}>Logout</button>

      <hr />

      <h3>Add New Student</h3>
      {msg && <p>{msg}</p>}

      <form onSubmit={handleAddStudent}>
        <input
          type="text"
          name="name"
          value={newStudent.name}
          placeholder="Enter student name..."
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="email"
          name="email"
          value={newStudent.email}
          placeholder="Enter student email..."
          onChange={handleChange}
        />
        <br /><br />

        <input
          type="password"
          name="password"
          value={newStudent.password}
          placeholder="Enter student password..."
          onChange={handleChange}
        />
        <br /><br />

        <button type="submit">Add Student</button>
      </form>

      <hr />

      <h3>All Students ({students.length})</h3>
      {students.length === 0 ? (
        <p>No students registered yet.</p>
      ) : (
        <table border="1" cellPadding="8">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Role</th>
            </tr>
          </thead>
          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.email}</td>
                <td>{s.role}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default TeacherDashboard;
