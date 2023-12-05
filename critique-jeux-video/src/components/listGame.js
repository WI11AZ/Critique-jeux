import React from 'react';
import Game from './game';

const gameList = [
  { id: 1, name: 'Pokemon go', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780511/Pokemon-GO_q4m0vb.jpg' },
  { id: 2, name: 'Mario kart', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780509/MarioKart8Deluxe_t1kpjh.jpg' },
  { id: 3, name: 'FIFA 21', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/FIFA21_cf89b7.jpg' },
  { id: 4, name: 'Minecraft', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780510/Minecraft_acxrhf.jpg' },
  { id: 5, name: 'GTA 5', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/GTA5_gvltpb.jpg' },
  { id: 6, name: 'Terraria', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780512/Terraria_upttxp.jpg' },
  { id: 7, name: 'Outer WILDS', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780510/OuterWilds_td9jmn.jpg' },
  { id: 8, name: 'League of legend', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/League-of-legends_cvu8ut.jpg' },
  { id: 9, name: 'Dofus', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/Dofus_uiy2yp.jpg' },
  { id: 10, name: 'Portal', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780511/Portal_yuyelg.jpg' },
  { id: 11, name: 'Among US', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780508/AmongUS_jbkzyk.jpg' },
  { id: 12, name: 'Prison architect', image: 'https://res.cloudinary.com/drb3mrsdi/image/upload/v1701780511/PrisonArchitect_ephi0n.jpg' },

﻿
];

function listGame() {
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

export default listGame;