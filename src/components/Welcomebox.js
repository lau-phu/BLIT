import React, { useEffect } from "react";
import '../style.css';

function randomRGB() {
    return Math.floor(Math.random() * 256);
}

function getRandomColor() {
    var red = randomRGB();
    var green = randomRGB();
    var blue = randomRGB();
    return `rgb(${red}, ${green}, ${blue})`;
}

const Welcomebox = () => {
    useEffect(() => {
        const flashColor = () => {
            document.getElementById('welcome-box').style.backgroundColor = getRandomColor();
        };
        setInterval(flashColor, 2000000);
    }, []);

    return (
        <div id="welcome-box" style={{ width: 1000, height: 500, border: '1px solid black', padding: 20, textAlign: 'center' }}>
            <h1>Welcome!</h1>
        </div>
    );
};

export default Welcomebox;