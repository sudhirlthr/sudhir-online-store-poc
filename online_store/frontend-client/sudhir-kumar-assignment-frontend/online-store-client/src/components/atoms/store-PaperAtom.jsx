import React from 'react';
import { Paper} from '@material-ui/core';

export default function StorePaper(props){
    const className = props.className;
    return (<Paper className={className}/>)
}