import React from 'react';
import {Grid} from '@material-ui/core';

export default function StoreGrid(props){
    const spacing = props.spacing;
    const alignItems = props.alignItems;
    const md = props.md;
    const sm = props.sm;
    const xs = props.xs;
    const type = props.type;

    const justify = props.justify;
    const style = props.style;

    const subject = props.subject;
    
    return (
        <Grid spacing={spacing} alignItems={alignItems} md={md} sm={sm} xs={xs} justify={justify} style={style} />
    );
}