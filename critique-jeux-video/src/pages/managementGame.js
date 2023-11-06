import React from 'react';
import NavigationAdmin from '../components/navigationAdmin';
import AddGame from '../components/addGame';
import RemoveGame from '../components/removeGame';
import UpdateGame from '../components/updateGame';

const managementGame = () => {
    return (
        <div>
            <NavigationAdmin />
            <div className="management-container">
                <div className="management-component">
                <AddGame />
            </div>
            <div className="management-component">
                <RemoveGame />
            </div>
            <div className="management-component">
                <UpdateGame />
            </div>
            </div>
        </div>
    );
};

export default managementGame;