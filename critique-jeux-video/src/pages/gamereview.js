// gamereview.js
import React from 'react';
import { useParams } from 'react-router-dom';
import ListGame from '../components/listGame'; // Importez le composant ListGame
import stylesDetail from '../styles/details.module.css'; 

const GameReview = () => {
  const { id } = useParams();
  const gameList = ListGame.props.gameList; // Accédez à la propriété gameList du composant ListGame
  const game = gameList.find((g) => g.id.toString() === id);

  if (!game) {
    return <div>Erreur : jeu non trouvé</div>;
  }

  return (
    <div style={{ display: 'flex', textAlign:'center' }} className={stylesDetail['background']}>
      <div style={{ flex: 3, padding: '20px' }}>
        {/* Côté gauche (75%) */}
        <h1 style={{ color: '#fff', textTransform: 'uppercase' }}>{game.name}</h1>

        <img src={game.image} alt={game.name.toUpperCase()} style={{ width: '500px', height: '500px' }} />
        <h2 style={{ color: '#fff' }}>Description du jeu : </h2>
        <p style={{ color: '#fff', fontSize: '21px' }}>{game.description}</p>
        {/* Ajoutez des détails supplémentaires au besoin */}
      </div>
      <div style={{ flex: 1, padding: '20px'} }>
        {/* Liste des commentaires */}
        <div style={{ position: 'fixed', bottom: 25 }}>
          <input type="text" placeholder="Ajouter un commentaire" required style={{ width:'300px' }} />
          <input type="submit"  value="send" style={{ marginLeft: 3 }}/>
        </div>
      </div>
    </div>
  );
}

export default GameReview;
