import React from 'react';
import GridList from '@material-ui/core/GridList';

export default function StoreGridList(props){
    const cellHeight = props.cellHeight;
    const className = props.className;
    const cols = props.cols;
    const spacing = props.spacing;
    const children  = props.children;
    return(<GridList cellHeight={cellHeight} className={className} cols={cols} spacing={spacing}>
                {children}
            </GridList>
        );
}