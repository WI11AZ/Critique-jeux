import React from 'react';
import './../styles/navigation.css';
import { NavLink } from 'react-router-dom';



const Navigation = () => {
    return (
        <nav>
            <div class="onglets">
                <ul>Games</ul>
            </div>

            <div class="buttons">
                <NavLink to="/register" className="login">Register</NavLink> 
                <NavLink to="/login" className="register">Login</NavLink>
            </div>
        </nav>  
    );
};

export default Navigation;
