import React from 'react';
import Game from './game';

const gameList = [
  { id: 1, name: 'Pokemon go', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780511/Pokemon-GO_q4m0vb.jpg', description:"ceci est un commentaire" },
  { id: 2, name: 'Mario kart', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780509/MarioKart8Deluxe_t1kpjh.jpg', description:"ceci est un commentaire" },
  { id: 3, name: 'FIFA 21', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/FIFA21_cf89b7.jpg', description:"ceci est un commentaire" },
  { id: 4, name: 'Minecraft', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780510/Minecraft_acxrhf.jpg', description:"ceci est un commentaire" },
  { id: 5, name: 'GTA 5', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/GTA5_gvltpb.jpg', description:"ceci est un commentaire" },
  { id: 6, name: 'Terraria', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780512/Terraria_upttxp.jpg', description:"ceci est un commentaire" },
  { id: 7, name: 'Outer WILDS', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780510/OuterWilds_td9jmn.jpg', description:"ceci est un commentaire" },
  { id: 8, name: 'League of legend', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/League-of-legends_cvu8ut.jpg', description:"ceci est un commentaire" },
  { id: 9, name: 'Dofus', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/Dofus_uiy2yp.jpg', description:"ceci est un commentaire" },
  { id: 10, name: 'Portal', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780511/Portal_yuyelg.jpg', description:"ceci est un commentaire" },
  { id: 11, name: 'Among US', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/AmongUS_jbkzyk.jpg', description:"ceci est un commentaire" },
  { id: 12, name: 'Prison architect', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780511/PrisonArchitect_ephi0n.jpg', description:"ceci est un commentaire" },

﻿
];

function ListGame() {
  return (
    <div className="container mt-4">
      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
        {gameList.map((game) => (
          <div className="col mb-4" key={game.id}>
            <Game game={game} />
          </div>
        ))}
      </div>
    </div>
  );
}

ListGame.props = {
  gameList: gameList, // Déclarez la propriété gameList dans le composant ListGame
};

export default ListGame;

