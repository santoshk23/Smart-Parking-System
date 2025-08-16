import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [token, setToken] = useState(null);
  const [parkingLots, setParkingLots] = useState([]);

  const login = async () => {
    try {
      const res = await axios.post('http://localhost:8081/auth/login', {
        email,
        password,
      });
      console.log('Login response:', res.data);
      setToken(res.data.token);
      alert('Login successful!');
    } catch (error) {
      console.error('Login error:', error.response || error);
      alert('Login failed!');
    }
  };

  const fetchParkingLots = async () => {
    if (!token) {
      alert('Please login first');
      return;
    }
    try {
      const res = await axios.get('http://localhost:8081/manager/parking-lots/all', {
        headers: { Authorization: `Bearer ${token}` },
      });
      console.log('Parking lots data:', res.data);
      setParkingLots(res.data);
    } catch (error) {
      alert('Failed to fetch parking lots');
      console.error(error);
    }
  };

  console.log('parkingLots state:', parkingLots);

  // Styles object
  const styles = {
    container: {
      maxWidth: 600,
      margin: '40px auto',
      padding: 30,
      fontFamily: "'Roboto', sans-serif",
      backgroundColor: '#fff',
      borderRadius: 6,
      boxShadow: '0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23)',
    },
    heading: {
      textAlign: 'center',
      color: '#3f51b5',
      marginBottom: 30,
    },
    input: {
      width: '100%',
      padding: 12,
      marginBottom: 20,
      fontSize: 16,
      borderRadius: 4,
      border: '1px solid #ddd',
      boxSizing: 'border-box',
      outline: 'none',
      transition: 'border-color 0.2s',
    },
    button: {
      padding: '12px 30px',
      fontSize: 16,
      borderRadius: 4,
      border: 'none',
      cursor: 'pointer',
      backgroundColor: '#3f51b5',
      color: '#fff',
      fontWeight: '500',
      transition: 'background-color 0.2s',
      marginRight: 15,
    },
    list: {
      listStyle: 'none',
      padding: 0,
      marginTop: 30,
    },
    listItem: {
      backgroundColor: '#e8eaf6',
      padding: 18,
      marginBottom: 12,
      borderRadius: 4,
      color: '#303f9f',
    },
    noData: {
      color: '#757575',
      fontStyle: 'italic',
      textAlign: 'center',
      marginTop: 25,
    },
  };


  // For hover effect on buttons, we'll add simple handlers
  const [loginHover, setLoginHover] = React.useState(false);
  const [fetchHover, setFetchHover] = React.useState(false);
  const [dummyHover, setDummyHover] = React.useState(false);

  return (
      <div style={styles.container}>
        {!token ? (
            <>
              <h2 style={styles.heading}>Login</h2>
              <input
                  style={styles.input}
                  placeholder="Email"
                  value={email}
                  onChange={e => setEmail(e.target.value)}
                  onFocus={e => (e.target.style.borderColor = '#007bff')}
                  onBlur={e => (e.target.style.borderColor = '#ccc')}
              />
              <input
                  style={styles.input}
                  type="password"
                  placeholder="Password"
                  value={password}
                  onChange={e => setPassword(e.target.value)}
                  onFocus={e => (e.target.style.borderColor = '#007bff')}
                  onBlur={e => (e.target.style.borderColor = '#ccc')}
              />
              <button
                  style={{
                    ...styles.button,
                    backgroundColor: loginHover ? '#0056b3' : '#007bff',
                  }}
                  onMouseEnter={() => setLoginHover(true)}
                  onMouseLeave={() => setLoginHover(false)}
                  onClick={login}
              >
                Login
              </button>
            </>
        ) : (
            <>
              <h2 style={styles.heading}>Parking Lots</h2>
              <button
                  style={{
                    ...styles.button,
                    backgroundColor: fetchHover ? '#0056b3' : '#007bff',
                  }}
                  onMouseEnter={() => setFetchHover(true)}
                  onMouseLeave={() => setFetchHover(false)}
                  onClick={fetchParkingLots}
              >
                Load Parking Lots (From API)
              </button>{' '}
              {parkingLots.length === 0 ? (
                  <p style={styles.noData}>No parking lots found.</p>
              ) : (
                  <ul style={styles.list}>
                    {parkingLots.map(lot => (
                        <li key={lot.id} style={styles.listItem}>
                          <strong>{lot.name}</strong> - {lot.location}
                        </li>
                    ))}
                  </ul>
              )}
            </>
        )}
      </div>
  );
}

export default App;
