import React from 'react';
import { TextField} from '@material-ui/core';

export default function StoreTextField(props){
    const id = props.id;
    const label = props.label;
    const type = props.type;
    const variant = props.variant;
    const margin = props.margin;
    const name = props.name;
    const autoComplete = props.autoComplete;
    
    return(<TextField  id={id} 
        label={label} 
        type={type} 
        variant={variant}
        margin={margin}
        name={name}
        autoComplete={autoComplete}
        required fullWidth autoFocus/>)
}