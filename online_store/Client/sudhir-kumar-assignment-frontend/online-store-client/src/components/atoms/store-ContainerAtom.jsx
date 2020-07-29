import React from 'react';
import Container from '@material-ui/core/Container';

export default function storeContainer(props){
    const component = props.component;
    const maxWidth = props.maxWidth;

    return(<Container component="main" maxWidth="xs"/>)
}