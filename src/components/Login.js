// Login.js

import React, { useState, useEffect } from 'react';
import { Alert } from 'react-alert';
import Display from './ShowDiary'
import { login } from '../service/apiService'; // Adjust path as per your project structure
import { getDiary } from '../service/apiService';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [diaries, setDiaries] = useState([]);
    const [error, setError] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            // alert(username + " " + password);
            const writerData = await getDiary;
            alert(writerData.data)
            Display(writerData.data); // Assuming writerData.diaries is an array of diary objects
        } catch (error) {
            setError('Failed to fetch writer data. Please check your credentials.');
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <label>
                    Username:
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </label>
                <br />
                <label>
                    Password:
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </label>
                <br />
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default Login;
