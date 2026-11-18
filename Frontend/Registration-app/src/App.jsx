import { useState } from 'react';
import Register from './components/Register';
import Login from './components/Login';
import TeacherDashboard from './components/TeacherDashboard';
import StudentDashboard from './components/StudentDashboard';

const App = () => {
  const [currentUser, setCurrentUser] = useState(null);
  const [view, setView] = useState("login");

  const handleLogout = () => {
    setCurrentUser(null);
    setView("login");
  };

  if (currentUser) {
    if (currentUser.role === "teacher") {
      return <TeacherDashboard user={currentUser} onLogout={handleLogout} />;
    } else {
      return <StudentDashboard user={currentUser} onLogout={handleLogout} />;
    }
  }

  return (
    <div>
      <div>
        <button onClick={() => setView("login")}>Login</button>
        {" "}
        <button onClick={() => setView("register")}>Register</button>
      </div>

      <hr />

      {view === "login" ? (
        <Login
          onLoginSuccess={(user) => setCurrentUser(user)}
          onSwitchToRegister={() => setView("register")}
        />
      ) : (
        <Register
          onRegisterSuccess={() => setView("login")}
          onSwitchToLogin={() => setView("login")}
        />
      )}
    </div>
  );
};

export default App;
