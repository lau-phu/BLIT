
import './App.css';

import Footer from './components/Footer';
import Header from './components/Header';
import Display from './components/ShowDiary';
import Login from './components/Login';
import Signup from './components/Signup';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

function App() {
  return (
    <div>
      <Header />
      <h1>welcome to mah diahhrie</h1>

      <div>
        <Router>
          <nav>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/login">login</Link>
              </li>
              <li>
                <Link to="/signup">signup</Link>
              </li>
            </ul>
          </nav>
          <Routes>
            <Route path="/" element={<Display />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Display />} />
          </Routes>
        </Router>
      </div>

      <Display />
      <Footer />
    </div>
  )
}

export default App;
