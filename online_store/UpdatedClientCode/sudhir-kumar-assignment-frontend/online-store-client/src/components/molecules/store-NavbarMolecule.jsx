import React from 'react';

import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import Menu from '../atoms/store-MenuAtom'; 

export default function NavbarMolecule(props){
    const classes = props.classes;
    return(
        <>
            <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
                <Menu />
            </IconButton>
            <Button color="inherit">Login</Button>
        </>
    );
}