import React from 'react';
import { Link, NavLink } from 'react-router-dom';

const ConnexionForm = () => {
 
  return (
    
    <div className="box">
      <div className="container">
        <div className="top-header">
          <span style={{ color: '#fff' }}>
            <Link to="/register" className='accueil'>Have an account?</Link>
          </span>
          <header>Login</header>
        </div>
        <div className="input-field">
          <input type="text" className="input" placeholder="Username" required />
          <i className="bx bx-user"></i>
        </div>
        <div className="input-field">
          <input type="password" className="input" placeholder="Password" required />
          <i className="bx bx-lock-alt"></i>
        </div>
        <div className="input-field">
          <input type="submit" className="submit" value="Login" />
        </div>
        <div class="invite">
          <NavLink to="/" className="accueil" class="invitecolor">Sign in as a guest</NavLink>
        </div>
        <div className="bottom">
          <div className="left">
            <input type="checkbox" id="check" />
            <label for="check"> Remember Me</label>
          </div>
          <div className="right">
            <label>Forgot password?</label>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ConnexionForm;
