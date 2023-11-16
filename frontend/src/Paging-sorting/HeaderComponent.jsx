import React from 'react';
import { Link } from 'react-router-dom';

function HeaderComponent() {
  
  return (
    <header className="border-bottom border-light border-5 mb-5 p-2 bg-dark text-light">
      <div className="container">
        <div className="row">
          <nav className="navbar navbar-expand-lg">
            <Link className="navbar-brand ms-2 fs-2 fw-bold text-light" to="/">
              🚀 TASK
            </Link>
            <div className="collapse navbar-collapse">
              <ul className="navbar-nav">
                <li className="nav-item fs-5">
                  <Link className="nav-link text-white" to="/employees">
                     Employees
                  </Link>
                </li>
                <li className="nav-item fs-5">
                  <Link className="nav-link text-white" to="/employees-with-department">
                    📋 List
                  </Link>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </header>
  );
}

export default HeaderComponent;
