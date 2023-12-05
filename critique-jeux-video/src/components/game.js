import React from 'react';
import { Link } from 'react-router-dom';

function Game({ game }) {
  return (
    <div className="card h-100" style={{ opacity: 0.9, backgroundColor: 'rgba(169, 169, 169, 0.5)', border: '1px solid white' }}>
      <Link to={`/details/${game.id}`}>
        <img src={game.image} className="card-img-top" alt={game.image} />
      </Link>

      <div className="card-body">
        <h5 className="card-title" style={{ color: 'white' }}>{game.name}</h5>
      </div>
    </div>
  );
}

export default Game;
