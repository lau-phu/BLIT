import React from "react";
import '../style.css';

export default function Footer() {

    // const currentYear = new Date().getFullYear();
    const currentYear = 2024;

    return (
        <div className="footer">
            <p className="footer-text">
                this is the year: {currentYear} </p>
        </div>
    );
}