import React from 'react';

function WelcomeComponent() {
  return (
    <div className="WelcomeComponent">
      <h1>
        Hello{' '}
        <span role="img" aria-label="Waving Hand">
          👋
        </span>
      </h1>
    </div>
  );
}

export default WelcomeComponent;
