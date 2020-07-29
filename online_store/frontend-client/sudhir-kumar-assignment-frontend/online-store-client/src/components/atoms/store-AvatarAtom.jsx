import React from 'react';
import Avatar from '@material-ui/core/Avatar';

export default function storeAvatar(props){
    const className = props.className;

    return(<Avatar className={className} />)
}