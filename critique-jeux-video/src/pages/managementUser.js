import React from 'react';
import NavigationAdmin from '../components/navigationAdmin';
import AddUser from '../components/addUser';
import RemoveUser from '../components/removeUser';
import UpdateUser from '../components/updateUser';

const managementUser = () => {
    return (
        <div>
            <NavigationAdmin />
            <div className="management-container">
                <div className="management-component">
                <AddUser/>
            </div>
            <div className="management-component">
                <RemoveUser/>
            </div>
            <div className="management-component">
                <UpdateUser/>
            </div>
            </div>
        </div>
    );
};

export default managementUser;