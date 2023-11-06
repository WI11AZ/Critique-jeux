import React from 'react';
import './../styles/navigation.css';
import { NavLink } from 'react-router-dom';




const navigationAdmin = () => {
    return (
        <div>
            <nav>
            <div class="onglets">
                <NavLink to="/accueilAdmin" className="accueil" class="invitecolor"><ul>Home</ul></NavLink>
                <NavLink to="/accueilAdmin/managementGame" className="accueil" class="invitecolor"><ul>Management Game</ul></NavLink>
                <NavLink to="/accueilAdmin/managementUser" className="accueil" class="invitecolor"><ul>Management User</ul></NavLink>
            </div>
            <div class="buttons">
                <NavLink to="/register" className="login">Register</NavLink> 
                <NavLink to="/login" className="register">Login</NavLink>
            </div>
        </nav>  
            
        </div>
    );
};

export default navigationAdmin;


