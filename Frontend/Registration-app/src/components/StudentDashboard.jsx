import { useState, useEffect } from 'react';
import axios from 'axios';

const StudentDashboard = ({ user, onLogout }) => {
  const API = "http://localhost:8080/";
  const [details, setDetails] = useState(user);

  useEffect(() => {
    const fetchMyDetails = async () => {
      try {
        const res = await axios.get(`${API}api/user/${user.email}`);
        setDetails(res.data);
      } catch (err) {
        console.error("Error fetching student details:", err);
      }
    };

    if (user.email) {
      fetchMyDetails();
    }
  }, [user.email]);

  return (
    <div>
      <h2>Student Dashboard</h2>
      <p>Welcome, <b>{details.name}</b></p>
      <button onClick={onLogout}>Logout</button>

      <hr />

      <h3>My Details</h3>
      <p><b>Student ID:</b> {details.id}</p>
      <p><b>Name:</b> {details.name}</p>
      <p><b>Email:</b> {details.email}</p>
      <p><b>Role:</b> {details.role}</p>
    </div>
  );
};

export default StudentDashboard;
